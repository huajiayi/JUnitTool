package com.github.huajiayi.junittool.schema.custom.chainstock;

import com.github.huajiayi.junittool.schema.Api;
import com.github.huajiayi.junittool.schema.ControllerSchema;
import com.github.huajiayi.junittool.util.CommonUtil;
import lombok.Builder;
import lombok.Data;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Joey
 */
@Data
@Builder
public class ControllerTestSchema {

    private String packageName;

    @Builder.Default
    private Set<String> deps = new HashSet<>();

    private String description;

    private String name;

    private String resourceName;

    private String jsonName;

    private String baseUrl;

    private String author;

    private String operator;

    private String merchantId;

    private Read read;

    private Save save;

    private Update update;

    private Delete delete;

    @Builder.Default
    private List<Api> apis = new LinkedList<>();

    public static ControllerTestSchema build(ControllerSchema controllerSchema) {
        String name = controllerSchema.getName();
        String resourceName = controllerSchema.getResourceName();
        String jsonName = controllerSchema.getJsonName();
        String baseUrl = controllerSchema.getBaseUrl();
        String description = controllerSchema.getDescription();
        Set<String> deps = controllerSchema.getDepPackageMap().values().stream().collect(Collectors.toSet());

        ControllerTestSchema schema = ControllerTestSchema.builder()
                .deps(deps)
                .name(name)
                .resourceName(resourceName)
                .jsonName(jsonName)
                .baseUrl(baseUrl)
                .description(description)
                .build();
        schema.setPackageName("com.nhsoft.mars.chain.adapter.web");
        schema.setAuthor("nhsoft.huajy");
        schema.setOperator("ConstantsTest.OPERATOR_HUAJY");
        schema.setMerchantId("ConstantsTest.HUAJY_MERCHANT_ID_1");

        List<Api> apiList = controllerSchema.getApiList();
        controllerSchema.getApiList().forEach(api -> {
            String apiName = api.getName();
            if (api.getPathVariableList().size() > 0) {
                String textUrl = CommonUtil.formatTextUrl(api.getUrl());
                api.setUrl(textUrl);
            }

            switch (apiName) {
                case "read":
                    schema.fillRead(api);
                    break;
                case "save":
                    schema.fillSave(api);
                    break;
                case "update":
                    schema.fillUpdate(api);
                    break;
                case "delete":
                    schema.fillDelete(api);
                    break;
                default:
                    break;
            }
        });

        String[] filterNames = new String[]{"read", "save", "update", "delete"};
        List<Api> apis = apiList.stream()
                .filter(api -> {
                    String apiName = api.getName();
                    return Arrays.stream(filterNames).noneMatch(n -> n.equals(apiName));
                }).collect(Collectors.toList());
        schema.setApis(apis);

        return schema;
    }

    private void fillRead(Api api) {
        Read read = Read.build(api);
        this.setRead(read);
    }

    private void fillSave(Api api) {
        Save save = Save.build(api);
        this.setSave(save);
    }

    private void fillUpdate(Api api) {
        Update update = Update.build(api);
        this.setUpdate(update);
    }

    private void fillDelete(Api api) {
        Delete delete = Delete.build(api);
        this.setDelete(delete);
    }
}
