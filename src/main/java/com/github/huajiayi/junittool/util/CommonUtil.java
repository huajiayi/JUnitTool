package com.github.huajiayi.junittool.util;

import com.github.huajiayi.junittool.PathMap;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import org.apache.commons.lang.StringUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Joey
 */
public class CommonUtil {

    public static void fillDepPackageMap(CompilationUnit cu, Map<String, String> depPackageMap) {
        cu.getImports().forEach(dep -> {
            String depName = dep.getNameAsString();
            String[] clazzNameSplit = depName.split("\\.");
            String clazzName = clazzNameSplit[clazzNameSplit.length - 1];
            depPackageMap.put(clazzName, depName);
        });

        // 导入package所在目录下的class
        Optional<PackageDeclaration> packageOption = cu.getPackageDeclaration();
        packageOption.ifPresent(pkg -> {
            String name = pkg.getNameAsString();
            Map<String, String> classPathMap = PathMap.getInstance();
            String packagePath = classPathMap.get(name);
            File file = new File(packagePath);
            Arrays.stream(file.listFiles()).forEach(f -> {
                String className = f.getName();
                String clazzName = className.substring(0, className.length() - 5);
                depPackageMap.put(clazzName, name + "." + clazzName);
            });
        });

    }

    public static Map<String, String> parseAnnotation(AnnotationExpr annotation) {
        List<Node> childNodes = annotation.getChildNodes();
        List<String> pairList = childNodes.stream()
                .skip(1)
                .map(node -> node.toString())
                .collect(Collectors.toList());
        Map<String, String> annotationMap = parseAnnotationPairs(pairList);

        return annotationMap;
    }

    public static Map<String, String> parseAnnotationPairs(List<String> pairs) {
        return pairs.stream()
                .map(o -> {
                    String[] split = o.split("=");
                    // 注解使用简写
                    if (split.length == 1) {
                        if (split[0].charAt(0) == '"') {
                            split[0] = split[0].substring(1, split[0].length() - 1);
                        }

                        return new String[]{"value", split[0]};
                    }

                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    // 去掉字符串的冒号
                    if (split[1].charAt(0) == '"') {
                        split[1] = split[1].substring(1, split[1].length() - 1);
                    }

                    return split;
                })
                .collect(Collectors.toMap(o -> o[0], o -> o[1]));
    }

    public static String formatUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return "";
        }

        if (url.charAt(0) != '/') {
            url = "/" + url;
        }

        if (url.charAt(url.length() - 1) == '/') {
            url = url.substring(0, url.length() - 1);
        }

        return url;
    }

    public static String formatTextUrl(String url) {
        return url.replaceAll("[{]", "\" + ")
                .replaceAll("[}]", " + \"");
    }

    public static String camelToSnake(String camelStr) {
        String ret = camelStr.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2");
        return ret.toLowerCase();
    }

    public static String toSmallCamel(String str) {
        char[] chars = str.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return String.valueOf(chars);
    }

    public static String toBigCamel(String str) {
        char[] chars = str.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return String.valueOf(chars);
    }
}
