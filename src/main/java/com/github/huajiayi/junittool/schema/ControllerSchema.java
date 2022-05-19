package com.github.huajiayi.junittool.schema;

import com.github.huajiayi.junittool.util.CommonUtil;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import lombok.Builder;
import lombok.Data;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Joey
 */
@Data
@Builder
public class ControllerSchema {

    @Builder.Default
    private final Map<String, String> depPackageMap = new HashMap();

    private String name;

    private String resourceName;

    private String jsonName;

    private String description;

    private String baseUrl;

    @Builder.Default
    private final List<Api> apiList = new LinkedList<>();

    public static ControllerSchema build(ClassOrInterfaceDeclaration controller, CompilationUnit cu) {
        String name = controller.getNameAsString();
        ControllerSchema controllerSchema = ControllerSchema.builder()
                .name(name)
                .build();

        controllerSchema.fillResourceName();
        controllerSchema.fillJsonName();
        controllerSchema.fillDescription(controller);
        controllerSchema.fillBaseUrl(controller);
        controllerSchema.fillDeps(cu);

        controller.getMethods().stream()
                .map(method -> Api.build(method, controllerSchema.getDepPackageMap()))
                .forEach(api -> {
                    controllerSchema.getApiList().add(api);
                });

        return controllerSchema;
    }

    public void fillDeps(CompilationUnit cu) {
        CommonUtil.fillDepPackageMap(cu, this.getDepPackageMap());
    }

    private void fillDescription(ClassOrInterfaceDeclaration controller) {
        Optional<AnnotationExpr> apiOption = controller.getAnnotationByName("Api");
        apiOption.ifPresent(annotation -> {
            Map<String, String> annotationMap = CommonUtil.parseAnnotation(annotation);
            String description = annotationMap.getOrDefault("tags", "");
            this.setDescription(description);
        });
    }

    private void fillBaseUrl(ClassOrInterfaceDeclaration controller) {
        Optional<AnnotationExpr> requestMappingOption = controller.getAnnotationByName("RequestMapping");
        requestMappingOption.ifPresent(annotation -> {
            Map<String, String> annotationMap = CommonUtil.parseAnnotation(annotation);
            String baseUrl = annotationMap.getOrDefault("value", "");
            baseUrl = CommonUtil.formatUrl(baseUrl);
            this.setBaseUrl(baseUrl);
        });
    }

    private void fillResourceName() {
        String name = this.getName();
        String nameWithController = name.replace("Controller", "");
        String resourceName = CommonUtil.toSmallCamel(nameWithController);
        this.setResourceName(resourceName);
    }

    private void fillJsonName() {
        String name = this.getName();
        String nameWithController = name.replace("Controller", "");
        String jsonName = CommonUtil.camelToSnake(nameWithController);
        this.setJsonName(jsonName);
    }
}

