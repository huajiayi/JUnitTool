package com.github.huajiayi.junittool.schema;

import com.github.huajiayi.junittool.PathMap;
import com.github.huajiayi.junittool.util.CommonUtil;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author Joey
 */
@Data
@Builder
public class Param {

    private String type;

    private String name;

    private String jsonName;

    private String description;

    private String getter;

    private String setter;

    @Builder.Default
    private Boolean required = false;

    @Builder.Default
    private Boolean listIs = false;

    private String listItemType;

    /**
     * 如果是对象类型，取该对象的param,
     * 如果是集合类型，取集合泛型的param
     */
    @Builder.Default
    private final List<Param> paramList = new LinkedList<>();

    @SneakyThrows
    public static Param build(Parameter parameter, Map<String, String> depPackageMap) {
        String name = parameter.getNameAsString();
        String type = parameter.getTypeAsString();

        Param param = Param.build(type, name, depPackageMap);
        param.fillDescription(parameter);

        return param;
    }

    public static Param build(String type, String name, Map<String, String> depPackageMap) {
        return Param.build(type, name, depPackageMap, new HashSet<>());
    }

    @SneakyThrows
    public static Param build(String type, String name, Map<String, String> depPackageMap, Set<String> depSet) {
        // 如果存在相同的依赖，说明有循环依赖，直接跳过解析
        if (depSet.contains(type)) {
            Param param = Param.builder()
                    .type(type)
                    .name(name)
                    .description(name)
                    .build();
            param.fillGetterAndSetter();
            param.fillJsonName();
            param.fillListIs();
            return param;
        }
        depSet.add(type);

        Param param = Param.builder()
                .type(type)
                .name(name)
                .build();
        param.fillGetterAndSetter();
        param.fillJsonName();
        param.fillListIs();
        if (param.getListIs()) {
            type = param.getListItemType();
        }

        if (!depPackageMap.containsKey(type)) {
            return param;
        }

        String packageName = depPackageMap.get(type);
        Map<String, String> classPathMap = PathMap.getInstance();

        if(!classPathMap.containsKey(packageName)) {
            return param;
        }

        String packagePath = classPathMap.get(packageName);
        CompilationUnit cu = StaticJavaParser.parse(new File(packagePath));
        Map<String, String> classDepPackageMap = new HashMap<>();
        CommonUtil.fillDepPackageMap(cu, classDepPackageMap);
        Optional<ClassOrInterfaceDeclaration> clazzOption = cu.getClassByName(type);
        if (clazzOption.isEmpty()) {
            return param;
        }

        ClassOrInterfaceDeclaration clazz = clazzOption.get();
        List<FieldDeclaration> fields = clazz.getFields();
        fields.forEach(field -> {
            NodeList<VariableDeclarator> variables = field.getVariables();
            variables.forEach(variable -> {
                String paramName = variable.getNameAsString();
                String paramtType = variable.getTypeAsString();
                if ("serialVersionUID".equals(paramName)) {
                    return;
                }

                Param subParam = Param.build(paramtType, paramName, classDepPackageMap, depSet);
                subParam.fillDescription(field);
                param.getParamList().add(subParam);
            });
        });

        return param;
    }

    public static Optional<Param> buildByAnnotationName(Parameter parameter, String annotationName, Map<String, String> depPackageMap) {
        Optional<AnnotationExpr> annotationOption = parameter.getAnnotationByName(annotationName);
        if (annotationOption.isEmpty()) {
            return Optional.empty();
        }

        String name = parameter.getNameAsString();
        String type = parameter.getTypeAsString();

        Param param = Param.build(type, name, depPackageMap);
        param.fillDescription(parameter);

        AnnotationExpr annotation = annotationOption.get();
        Map<String, String> annotationMap = CommonUtil.parseAnnotation(annotation);
        param.fillJsonName(annotationMap);
        param.fillRequired(annotationMap);

        return Optional.of(param);
    }

    private void fillJsonName() {
        if (StringUtils.isNotBlank(this.getJsonName())) {
            return;
        }

        String jsonName = CommonUtil.camelToSnake(this.name);
        this.setJsonName(jsonName);
    }

    private void fillListIs() {
        if (StringUtils.contains(this.type, "List")) {
            this.setListIs(true);
            fillListItemType();
        }
    }

    private void fillJsonName(Map<String, String> annotationMap) {
        String value = annotationMap.getOrDefault("value", "");
        if (StringUtils.isNotBlank(value)) {
            this.setJsonName(value);
            return;
        }

        String name = annotationMap.getOrDefault("name", "");
        if (StringUtils.isNotBlank(name)) {
            this.setJsonName(name);
            return;
        }

        this.setJsonName(this.name);
    }

    private void fillRequired(Map<String, String> annotationMap) {
        String required = annotationMap.getOrDefault("required", "true");
        this.setRequired(required.equals("true"));
    }

    private void fillListItemType() {
        int index = this.type.indexOf("<");
        String listItemType = this.type.substring(index + 1, this.type.length() - 1);
        this.setListItemType(listItemType);
    }

    private void fillGetterAndSetter() {
        String name = this.getName();
        String nameBigCamel = CommonUtil.toBigCamel(name);
        this.setGetter("get" + nameBigCamel);
        this.setSetter("set" + nameBigCamel);
    }

    private void fillDescription(Parameter parameter) {
        Optional<AnnotationExpr> annotationExprOptional = parameter.getAnnotationByName("ApiOperation");
        Optional<Comment> commentOptional = parameter.getComment();
        fillDescription(annotationExprOptional, commentOptional);
    }

    private void fillDescription(FieldDeclaration fieldDeclaration) {
        Optional<AnnotationExpr> annotationExprOptional = fieldDeclaration.getAnnotationByName("ApiOperation");
        Optional<Comment> commentOptional = fieldDeclaration.getComment();
        fillDescription(annotationExprOptional, commentOptional);
    }

    private void fillDescription(Optional<AnnotationExpr> annotationExprOptional, Optional<Comment> commentOptional) {
        String desc = this.getName();

        // 有ApiOperation用ApiOperation中的value
        if (annotationExprOptional.isPresent()) {
            AnnotationExpr annotation = annotationExprOptional.get();
            Map<String, String> annotationMap = CommonUtil.parseAnnotation(annotation);
            String description = annotationMap.getOrDefault("value", desc);
            this.setDescription(description);
            return;
        }

        // 否则用注释中的值
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            String content = comment.getContent();
            String[] contents = content.split("\r\n");

            if (contents.length > 1) {
                desc = contents[1];
                desc = desc.replace("*", "")
                        .replace(".", "")
                        .trim();
            }
        }

        this.setDescription(desc);
    }
}
