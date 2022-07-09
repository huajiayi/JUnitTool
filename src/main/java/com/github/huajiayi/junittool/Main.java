package com.github.huajiayi.junittool;

import com.github.huajiayi.junittool.config.GlobalConfig;
import com.github.huajiayi.junittool.schema.ControllerSchema;
import com.github.huajiayi.junittool.schema.custom.chainstock.ControllerTestSchema;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Optional;

/**
 * @author Joey
 */
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        // 生成ControllerSchema
        Map classPathMap = PathMap.init(GlobalConfig.PROJECT_PATH);
        System.out.println("find " + classPathMap.size() + " java files");

        File file = new File(GlobalConfig.FILE_PATH);
        CompilationUnit cu = StaticJavaParser.parse(file);
        String className = file.getName();
        className = className.substring(0, className.length() - 5);
        Optional<ClassOrInterfaceDeclaration> clazzOption = cu.getClassByName(className);
        if (clazzOption.isEmpty()) {
            throw new RuntimeException("class " + className + " not found");
        }

        ClassOrInterfaceDeclaration clazz = clazzOption.get();
        ControllerSchema controllerSchema = ControllerSchema.build(clazz, cu);

        // 把ControllerSchema转成ControllerTestSchema
        ControllerTestSchema schema = ControllerTestSchema.build(controllerSchema);

        // 生成模板
        String baseDir = "src/main/java/com/github/huajiayi/junittool";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        File templateDir = new File(baseDir + "/template");
        cfg.setDirectoryForTemplateLoading(templateDir);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("test.ftl");
        Map root = GlobalConfig.GLOBAL_PARAM_MAP;
        root.put("controller", schema);

        String controllerName = schema.getName();
        File testFile = new File("output/" + controllerName + "Test.java");
        if (!testFile.exists()) {
            testFile.createNewFile();
        }
        Writer out = new FileWriter(testFile);
        temp.process(root, out);
        System.out.println(testFile.getAbsolutePath());
    }
}
