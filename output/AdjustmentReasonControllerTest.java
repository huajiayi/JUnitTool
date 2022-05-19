package com.nhsoft.mars.chain.adapter.web;

import com.google.common.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.nhsoft.mars.json.MockUtil;
import com.nhsoft.mars.test.BaseTest;
import com.nhsoft.mars.test.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

/**
* AdjustmentReasonController单元测试.
*
* @author nhsoft.huajy
*/
public class AdjustmentReasonControllerTest extends BaseTest {

    private static final String BASE_URL = "/admin/api/internal";

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = JsonUtil.getGson(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    /**
    * 初始化.
    */
    @Before
    public void setup() {

    }
    /**
    * 读取测试.
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testRead() throws Exception {
        AdjustmentReasonVO adjustmentReasonVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, adjustmentReasonVORead.getId());
        Assert.assertEquals(, adjustmentReasonVORead.getMerchantId());
        Assert.assertEquals(, adjustmentReasonVORead.getReason());
        Assert.assertEquals(, adjustmentReasonVORead.getInoutIs());
        Assert.assertEquals(, adjustmentReasonVORead.getLocationId());
        Assert.assertEquals(, adjustmentReasonVORead.getCreator());
        Assert.assertEquals(, adjustmentReasonVORead.getCreatedAt());
        Assert.assertEquals(, adjustmentReasonVORead.getUpdator());
        Assert.assertEquals(, adjustmentReasonVORead.getUpdatedAt());
    }

    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testSave() throws Exception {
        AdjustmentReasonSaveVO adjustmentReasonSaveVO = MockUtil.fromFile("adjustment_reason_save.json", AdjustmentReasonSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonSaveVO, MockMvcResultMatchers.status().isCreated());
        AdjustmentReasonVO adjustmentReasonVOSaved = Printer.print(response, AdjustmentReasonVO.class);

        AdjustmentReasonVO adjustmentReasonVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonVOSaved.getId());
        Assert.assertEquals(adjustmentReasonSaveVO.getId(), adjustmentReasonVORead.getId());
        Assert.assertEquals(adjustmentReasonSaveVO.getMerchantId(), adjustmentReasonVORead.getMerchantId());
        Assert.assertEquals(adjustmentReasonSaveVO.getReason(), adjustmentReasonVORead.getReason());
        Assert.assertEquals(adjustmentReasonSaveVO.getInoutIs(), adjustmentReasonVORead.getInoutIs());
        Assert.assertEquals(adjustmentReasonSaveVO.getLocationId(), adjustmentReasonVORead.getLocationId());
        Assert.assertEquals(adjustmentReasonSaveVO.getCreator(), adjustmentReasonVORead.getCreator());
        Assert.assertEquals(adjustmentReasonSaveVO.getCreatedAt(), adjustmentReasonVORead.getCreatedAt());
        Assert.assertEquals(adjustmentReasonSaveVO.getUpdator(), adjustmentReasonVORead.getUpdator());
        Assert.assertEquals(adjustmentReasonSaveVO.getUpdatedAt(), adjustmentReasonVORead.getUpdatedAt());
    }

    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testUpdate() throws Exception {
        AdjustmentReasonSaveVO adjustmentReasonSaveVO = MockUtil.fromFile("adjustment_reason_save.json", AdjustmentReasonSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonSaveVO, MockMvcResultMatchers.status().isCreated());
        AdjustmentReasonVO adjustmentReasonVOSaved = Printer.print(response, AdjustmentReasonVO.class);

        AdjustmentReasonUpdateVO adjustmentReasonUpdateVO = MockUtil.fromFile("adjustment_reason_update.json", AdjustmentReasonUpdateVO.class);
        adjustmentReasonUpdateVO.setId(adjustmentReasonVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonUpdateVO, MockMvcResultMatchers.status().isOk());
        AdjustmentReasonVO adjustmentReasonVOUpdated = Printer.print(response, AdjustmentReasonVO.class);
        Assert.assertEquals(adjustmentReasonUpdateVO.getId(), adjustmentReasonVOUpdated.getId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getMerchantId(), adjustmentReasonVOUpdated.getMerchantId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getReason(), adjustmentReasonVOUpdated.getReason());
        Assert.assertEquals(adjustmentReasonUpdateVO.getInoutIs(), adjustmentReasonVOUpdated.getInoutIs());
        Assert.assertEquals(adjustmentReasonUpdateVO.getLocationId(), adjustmentReasonVOUpdated.getLocationId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getCreator(), adjustmentReasonVOUpdated.getCreator());
        Assert.assertEquals(adjustmentReasonUpdateVO.getCreatedAt(), adjustmentReasonVOUpdated.getCreatedAt());
        Assert.assertEquals(adjustmentReasonUpdateVO.getUpdator(), adjustmentReasonVOUpdated.getUpdator());
        Assert.assertEquals(adjustmentReasonUpdateVO.getUpdatedAt(), adjustmentReasonVOUpdated.getUpdatedAt());

        AdjustmentReasonVO adjustmentReasonVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonVOSaved.getId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getId(), adjustmentReasonVORead.getId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getMerchantId(), adjustmentReasonVORead.getMerchantId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getReason(), adjustmentReasonVORead.getReason());
        Assert.assertEquals(adjustmentReasonUpdateVO.getInoutIs(), adjustmentReasonVORead.getInoutIs());
        Assert.assertEquals(adjustmentReasonUpdateVO.getLocationId(), adjustmentReasonVORead.getLocationId());
        Assert.assertEquals(adjustmentReasonUpdateVO.getCreator(), adjustmentReasonVORead.getCreator());
        Assert.assertEquals(adjustmentReasonUpdateVO.getCreatedAt(), adjustmentReasonVORead.getCreatedAt());
        Assert.assertEquals(adjustmentReasonUpdateVO.getUpdator(), adjustmentReasonVORead.getUpdator());
        Assert.assertEquals(adjustmentReasonUpdateVO.getUpdatedAt(), adjustmentReasonVORead.getUpdatedAt());
    }

    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testDelete() throws Exception {
        AdjustmentReasonSaveVO adjustmentReasonSaveVO = MockUtil.fromFile("adjustment_reason_save.json", AdjustmentReasonSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonSaveVO, MockMvcResultMatchers.status().isCreated());
        AdjustmentReasonVO adjustmentReasonVOSaved = Printer.print(response, AdjustmentReasonVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        AdjustmentReasonVO adjustmentReason = read(ConstantsTest.HUAJY_MERCHANT_ID_1, adjustmentReasonVOSaved.getId());
        Assert.assertEquals(null, adjustmentReason);
    }

    /**
    * 测试查询库存调整原因.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/adjustment_reasons.json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("id_list", "")
                    .param("offset", "")
                    .param("limit", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<AdjustmentReasonVO>>() {}.getType();
    List<AdjustmentReasonVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }


    /**
    * 读取.
    *
    * @param merchantId 商户id
    * @param id id
    * @return 返回对象
    */
    private AdjustmentReasonVO read(final BigInteger merchantId,final BigInteger id) throws Exception {
        String url = BASE_URL + "/adjustment_reasons/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, AdjustmentReasonVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final AdjustmentReasonSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/adjustment_reasons.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                        .content(gson.toJson(saveVO)))
                .andExpect(resultMatcher)
                .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse;
    }

    /**
    * 更新.
    *
    * @param merchantId 商户id
    * @param updateVO   更新VO
    * @param resultMatcher 返回状态
    * @return 响应
    */
    private MockHttpServletResponse update(final BigInteger merchantId, final AdjustmentReasonUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/adjustment_reasons.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                        .content(gson.toJson(updateVO)))
                .andExpect(resultMatcher)
                .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse;
    }

    /**
    * 删除.
    *
    * @param merchantId 商户id
    * @param id id
    * @param resultMatcher 返回状态
    * @return 响应
    */
    private MockHttpServletResponse delete(final BigInteger merchantId, final BigInteger id, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/adjustment_reasons/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.delete(url)
        .contentType(MediaType.APPLICATION_JSON)
        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
        .andExpect(resultMatcher)
        .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse
    }
}
