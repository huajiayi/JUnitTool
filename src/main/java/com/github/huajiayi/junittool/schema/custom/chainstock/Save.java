package com.github.huajiayi.junittool.schema.custom.chainstock;

import com.github.huajiayi.junittool.schema.Api;
import com.github.huajiayi.junittool.schema.Param;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Save {

    private String url;

    private Param requestBody;

    private Param returnParam;

    public static Save build(Api api) {
        String url = api.getUrl();
        Param requestBody = api.getRequestBody();
        Param response = api.getResponse();
        Save save = Save.builder()
                .url(url)
                .requestBody(requestBody)
                .returnParam(response)
                .build();

        return save;
    }

}
