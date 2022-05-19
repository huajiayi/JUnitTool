package com.github.huajiayi.junittool.config;

import java.util.HashMap;
import java.util.Map;

public class GlobalConfig {

    /**
     * 项目目录，用于获取所有的Java类信息
     */
    public static final String PROJECT_PATH = "D:\\WorkSpace\\mars-server-chain-stock";

    /**
     * 要生成单元测试的Controller文件路径
     */
    public static final String FILE_PATH = "D:\\WorkSpace\\mars-server-chain-stock\\mars-server-stock\\mars-server-stock-adapter\\src\\main\\java\\com\\nhsoft\\mars\\stock\\adapter\\web\\AdjustmentReasonController.java";

    public static final Map<String, String> GLOBAL_PARAM_MAP = new HashMap<>() {
        {
            put("packageName", "com.nhsoft.mars.chain.adapter.web");
            put("author", "nhsoft.huajy");
            put("operator", "ConstantsTest.OPERATOR_HUAJY");
            put("merchantId", "ConstantsTest.HUAJY_MERCHANT_ID_1");
        }
    };
}
