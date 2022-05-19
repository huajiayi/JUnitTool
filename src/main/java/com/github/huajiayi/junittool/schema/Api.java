package com.github.huajiayi.junittool.schema;

import com.github.huajiayi.junittool.util.CommonUtil;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * @author Joey
 */
@Data
@Builder
public class Api {

    private String name;

    private String url;

    private String method;

    private String description;

    @Builder.Default
    private final List<Param> requestHeaderList = new LinkedList<>();

    @Builder.Default
    private final List<Param> pathVariableList = new LinkedList<>();

    @Builder.Default
    private final List<Param> requestParamList = new LinkedList<>();

    private Param requestBody;

    private Param response;

    public static Api build(MethodDeclaration method, Map<String, String> depPackageMap) {

        String name = method.getNameAsString();
        Api api = Api.builder()
                .name(name)
                .build();

        Optional<AnnotationExpr> apiOperationOption = method.getAnnotationByName("ApiOperation");
        apiOperationOption.ifPresent(annotation -> {
            Map<String, String> annotationMap = CommonUtil.parseAnnotation(annotation);
            String description = annotationMap.getOrDefault("value", "");
            api.setDescription(description);
        });

        Optional<AnnotationExpr> methodAnnotationOption = api.getMethodAnnotationAndFillMethod(method);
        methodAnnotationOption.ifPresent(annotation -> {
            Map<String, String> methodAnnotationMap = CommonUtil.parseAnnotation(annotation);
            String url = methodAnnotationMap.getOrDefault("value", "");
            url = CommonUtil.formatUrl(url);
            api.setUrl(url);
        });

        NodeList<Parameter> parameterList = method.getParameters();
        parameterList.stream().forEach(parameter -> {
            api.fillRequestHeaderList(parameter, depPackageMap);
            api.fillPathVariableList(parameter, depPackageMap);
            api.fillRequestParamList(parameter, depPackageMap);
            api.fillRequestBody(parameter, depPackageMap);
        });

        api.fillResponse(method.getTypeAsString(), depPackageMap);

        return api;
    }

    private Optional<AnnotationExpr> getMethodAnnotationAndFillMethod(MethodDeclaration method) {
        Optional<AnnotationExpr> getMappingOption = method.getAnnotationByName("GetMapping");
        if (getMappingOption.isPresent()) {
            this.setMethod("get");
            return getMappingOption;
        }

        Optional<AnnotationExpr> postMappingOption = method.getAnnotationByName("PostMapping");
        if (postMappingOption.isPresent()) {
            this.setMethod("post");
            return postMappingOption;
        }

        Optional<AnnotationExpr> putMappingOption = method.getAnnotationByName("PutMapping");
        if (putMappingOption.isPresent()) {
            this.setMethod("put");
            return putMappingOption;
        }

        Optional<AnnotationExpr> deleteMappingOption = method.getAnnotationByName("DeleteMapping");
        if (deleteMappingOption.isPresent()) {
            this.setMethod("delete");
            return deleteMappingOption;
        }

        return Optional.empty();
    }

    private void fillRequestHeaderList(Parameter parameter, Map<String, String> depPackageMap) {
        Optional<Param> paramOption = Param.buildByAnnotationName(parameter, "RequestHeader", depPackageMap);
        paramOption.ifPresent(param -> {
            this.getRequestHeaderList().add(param);
        });
    }

    private void fillPathVariableList(Parameter parameter, Map<String, String> depPackageMap) {
        Optional<Param> paramOption = Param.buildByAnnotationName(parameter, "PathVariable", depPackageMap);
        paramOption.ifPresent(param -> {
            this.getPathVariableList().add(param);
        });
    }

    private void fillRequestParamList(Parameter parameter, Map<String, String> depPackageMap) {
        Optional<Param> paramOption = Param.buildByAnnotationName(parameter, "RequestParam", depPackageMap);
        paramOption.ifPresent(param -> {
            this.getRequestParamList().add(param);
        });
    }

    private void fillRequestBody(Parameter parameter, Map<String, String> depPackageMap) {
        Optional<AnnotationExpr> requestBodyOption = parameter.getAnnotationByName("RequestBody");
        requestBodyOption.ifPresent(annotation -> {
            Param param = Param.build(parameter, depPackageMap);
            this.setRequestBody(param);
        });
    }

    private void fillResponse(String type, Map<String, String> depPackageMap) {
        if (type.startsWith("Response")) {
            int index = type.indexOf("<");
            type = type.substring(index + 1, type.length() - 1);
        }

        String name = CommonUtil.toSmallCamel(type);
        Param param = Param.build(type, name, depPackageMap);
        this.setResponse(param);
    }
}
