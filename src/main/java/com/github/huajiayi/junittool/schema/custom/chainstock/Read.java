package com.github.huajiayi.junittool.schema.custom.chainstock;

import com.github.huajiayi.junittool.schema.Api;
import com.github.huajiayi.junittool.schema.Param;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Read {

    @Builder.Default
    private List<Param> pathVariableList = new ArrayList<>();

    private String url;

    private Param returnParam;

    public static Read build(Api api) {
        String url = api.getUrl();
        List<Param> pathVariableList = api.getPathVariableList();
        Param response = api.getResponse();
        Read read = Read.builder()
                .url(url)
                .pathVariableList(pathVariableList)
                .returnParam(response)
                .build();

        return read;
    }
}
