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
* ProductFormulaController单元测试.
*
* @author nhsoft.huajy
*/
public class ProductFormulaControllerTest extends BaseTest {

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
        ProductFormulaVO productFormulaVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, productFormulaVORead.getId());
        Assert.assertEquals(, productFormulaVORead.getMerchantId());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductId());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductVariantId());
        Assert.assertEquals(, productFormulaVORead.getCreatedAt());
        Assert.assertEquals(, productFormulaVORead.getUpdatedAt());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductTitle());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductVariantTitle());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductVariantSku());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductVariantBarcode());
        Assert.assertEquals(, productFormulaVORead.getFinishedCategoryName());
        Assert.assertEquals(, productFormulaVORead.getFinishedBaseUnit());
        Assert.assertEquals(, productFormulaVORead.getFinishedCostPrice());
        Assert.assertEquals(, productFormulaVORead.getFinishedProductUnit());
        Assert.assertEquals(, productFormulaVORead.getMaterialList());
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
        ProductFormulaSaveVO productFormulaSaveVO = MockUtil.fromFile("product_formula_save.json", ProductFormulaSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductFormulaVO productFormulaVOSaved = Printer.print(response, ProductFormulaVO.class);

        ProductFormulaVO productFormulaVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaVOSaved.getId());
        Assert.assertEquals(productFormulaSaveVO.getId(), productFormulaVORead.getId());
        Assert.assertEquals(productFormulaSaveVO.getMerchantId(), productFormulaVORead.getMerchantId());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductId(), productFormulaVORead.getFinishedProductId());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductVariantId(), productFormulaVORead.getFinishedProductVariantId());
        Assert.assertEquals(productFormulaSaveVO.getCreatedAt(), productFormulaVORead.getCreatedAt());
        Assert.assertEquals(productFormulaSaveVO.getUpdatedAt(), productFormulaVORead.getUpdatedAt());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductTitle(), productFormulaVORead.getFinishedProductTitle());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductVariantTitle(), productFormulaVORead.getFinishedProductVariantTitle());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductVariantSku(), productFormulaVORead.getFinishedProductVariantSku());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductVariantBarcode(), productFormulaVORead.getFinishedProductVariantBarcode());
        Assert.assertEquals(productFormulaSaveVO.getFinishedCategoryName(), productFormulaVORead.getFinishedCategoryName());
        Assert.assertEquals(productFormulaSaveVO.getFinishedBaseUnit(), productFormulaVORead.getFinishedBaseUnit());
        Assert.assertEquals(productFormulaSaveVO.getFinishedCostPrice(), productFormulaVORead.getFinishedCostPrice());
        Assert.assertEquals(productFormulaSaveVO.getFinishedProductUnit(), productFormulaVORead.getFinishedProductUnit());
        Assert.assertEquals(productFormulaSaveVO.getMaterialList(), productFormulaVORead.getMaterialList());
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
        ProductFormulaSaveVO productFormulaSaveVO = MockUtil.fromFile("product_formula_save.json", ProductFormulaSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductFormulaVO productFormulaVOSaved = Printer.print(response, ProductFormulaVO.class);

        ProductFormulaMaterialUpdateVO productFormulaUpdateVO = MockUtil.fromFile("product_formula_update.json", ProductFormulaMaterialUpdateVO.class);
        productFormulaUpdateVO.setId(productFormulaVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaUpdateVO, MockMvcResultMatchers.status().isOk());
        Boolean productFormulaVOUpdated = Printer.print(response, Boolean.class);

        ProductFormulaVO productFormulaVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaVOSaved.getId());
        Assert.assertEquals(productFormulaUpdateVO.getId(), productFormulaVORead.getId());
        Assert.assertEquals(productFormulaUpdateVO.getMerchantId(), productFormulaVORead.getMerchantId());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductId(), productFormulaVORead.getFinishedProductId());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductVariantId(), productFormulaVORead.getFinishedProductVariantId());
        Assert.assertEquals(productFormulaUpdateVO.getCreatedAt(), productFormulaVORead.getCreatedAt());
        Assert.assertEquals(productFormulaUpdateVO.getUpdatedAt(), productFormulaVORead.getUpdatedAt());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductTitle(), productFormulaVORead.getFinishedProductTitle());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductVariantTitle(), productFormulaVORead.getFinishedProductVariantTitle());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductVariantSku(), productFormulaVORead.getFinishedProductVariantSku());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductVariantBarcode(), productFormulaVORead.getFinishedProductVariantBarcode());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedCategoryName(), productFormulaVORead.getFinishedCategoryName());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedBaseUnit(), productFormulaVORead.getFinishedBaseUnit());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedCostPrice(), productFormulaVORead.getFinishedCostPrice());
        Assert.assertEquals(productFormulaUpdateVO.getFinishedProductUnit(), productFormulaVORead.getFinishedProductUnit());
        Assert.assertEquals(productFormulaUpdateVO.getMaterialList(), productFormulaVORead.getMaterialList());
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
        ProductFormulaSaveVO productFormulaSaveVO = MockUtil.fromFile("product_formula_save.json", ProductFormulaSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductFormulaVO productFormulaVOSaved = Printer.print(response, ProductFormulaVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        ProductFormulaVO productFormula = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productFormulaVOSaved.getId());
        Assert.assertEquals(null, productFormula);
    }

    /**
    * 测试通过成品规格id读取商品配方.
    *
    * @throws Exception 异常
    */
    @Test
    public void testReadByFinishedProductVariantId() throws Exception {
        BigInteger finishedProductVariantId = ;

        String url = BASE_URL + "/product_formulas/read_by_finished_product_variant_id/" + finished_product_variant_id + ".json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试删除成品.
    *
    * @throws Exception 异常
    */
    @Test
    public void testDeleteByFinishedProductVariantId() throws Exception {
        BigInteger finishedProductVariantId = ;

        String url = BASE_URL + "/product_formulas/delete_by_finished_product_variant_id/" + finished_product_variant_id + ".json";
        mockMvc.perform(MockMvcRequestBuilders.delete(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试查询商品配方.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/product_formulas.json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("product_query_name", "")
                    .param("category_id_list", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("sort_order", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductFormulaVO>>() {}.getType();
    List<ProductFormulaVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试查询配方中规格id.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListProductVariantId() throws Exception {
        String url = BASE_URL + "/product_formulas/list_product_variant_id.json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("process_type", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<BigInteger>>() {}.getType();
    List<BigInteger> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试查询商品规格价格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantPrice() throws Exception {
        String url = BASE_URL + "/product_formulas/list_material_with_price.json.json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("variant_id_list", "")
                    .param("storehouse_id", "")
                    .param("location_id", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductFormulaVO>>() {}.getType();
    List<ProductFormulaVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }


    /**
    * 读取.
    *
    * @param merchantId 商户id
    * @param finishedProductVariantId finishedProductVariantId
    * @return 返回对象
    */
    private ProductFormulaVO read(final BigInteger merchantId,final BigInteger finishedProductVariantId) throws Exception {
        String url = BASE_URL + "/product_formulas/read_by_finished_product_variant_id/" + finished_product_variant_id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, ProductFormulaVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final ProductFormulaSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/product_formulas.json";
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
    private MockHttpServletResponse update(final BigInteger merchantId, final ProductFormulaMaterialUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/product_formulas/material.json";
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
        String url = BASE_URL + "/product_formulas/" + id + ".json";
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
