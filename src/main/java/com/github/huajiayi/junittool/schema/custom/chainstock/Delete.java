package com.github.huajiayi.junittool.schema.custom.chainstock;

import com.github.huajiayi.junittool.schema.Api;
import com.github.huajiayi.junittool.schema.Param;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Delete {

    @Builder.Default
    private List<Param> pathVariableList = new ArrayList<>();

    private String url;

    public static Delete build(Api api) {
        String url = api.getUrl();
        List<Param> pathVariableList = api.getPathVariableList();
        Delete delete = Delete.builder()
                .url(url)
                .pathVariableList(pathVariableList)
                .build();

        return delete;
    };
    
}
