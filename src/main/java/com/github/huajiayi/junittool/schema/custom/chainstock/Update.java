package com.github.huajiayi.junittool.schema.custom.chainstock;

import com.github.huajiayi.junittool.schema.Api;
import com.github.huajiayi.junittool.schema.Param;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Update {

    private String url;

    private Param requestBody;

    private Param returnParam;

    public static Update build(Api api) {
        String url = api.getUrl();
        Param requestBody = api.getRequestBody();
        Param response = api.getResponse();
        Update update = Update.builder()
                .url(url)
                .requestBody(requestBody)
                .returnParam(response)
                .build();

        return update;
    }

}
