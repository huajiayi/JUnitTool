package com.github.huajiayi.junittool;

import org.apache.commons.lang.StringUtils;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Joey
 */
public class PathMap {

    private static Map<String, String> map = new HashMap<>();

    public static Map<String, String> getInstance() {
        return map;
    }

    public static Map init(String projectPath) {
        File file = new File(projectPath);
        if (!file.isDirectory()) {
            throw new RuntimeException("path must be a directory");
        }

        traverse(file);
        Map<String, String> copyMap = Map.copyOf(map);
        copyMap.entrySet().forEach(entry -> {
            String key = entry.getKey();
            String[] keySplit = key.split("\\.");
            List<String> keySplitWithoutClass = Arrays.stream(keySplit).limit(keySplit.length - 1).collect(Collectors.toList());
            String packageName = StringUtils.join(keySplitWithoutClass, ".");

            String value = entry.getValue();
            Path path = Path.of(value);
            String packagePath = path.getParent().toString();

            map.put(packageName, packagePath);
        });

        return map;
    }

    public static void traverse(File file) {
        if (file.getName().equals("com")) {
            fillMap(file, "com");
            return;
        }

        Arrays.stream(file.listFiles())
                .filter(f -> f.isDirectory())
                .forEach(f -> {
                    traverse(f);
                });
    }

    public static void fillMap(File file, String className) {
        if (file.isFile() && className.endsWith(".java")) {
            map.put(className.substring(0, className.length() - 5), file.getAbsolutePath());
            return;
        }

        if (!file.isDirectory()) {
            return;
        }

        Arrays.stream(file.listFiles()).forEach(f -> {
            fillMap(f, className + "." + f.getName());
        });
    }
}
