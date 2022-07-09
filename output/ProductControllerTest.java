package com.nhsoft.mars.stock.adapter.web;

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
* ProductController单元测试.
*
* @author nhsoft.huajy
*/
@Transactional
public class ProductControllerTest extends BaseTest {

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
        ProductVO productVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, productVORead.getId());
        Assert.assertEquals(, productVORead.getMerchantId());
        Assert.assertEquals(, productVORead.getTitle());
        Assert.assertEquals(, productVORead.getProductTypeId());
        Assert.assertEquals(, productVORead.getDeleted());
        Assert.assertEquals(, productVORead.getCreatedAt());
        Assert.assertEquals(, productVORead.getUpdatedAt());
        Assert.assertEquals(, productVORead.getDeletedAt());
        Assert.assertEquals(, productVORead.getShorthandCharacter());
        Assert.assertEquals(, productVORead.getFirstCharacter());
        Assert.assertEquals(, productVORead.getStopPurchaseIs());
        Assert.assertEquals(, productVORead.getDisuseIs());
        Assert.assertEquals(, productVORead.getStopSellIs());
        Assert.assertEquals(, productVORead.getSyncSource());
        Assert.assertEquals(, productVORead.getCategoryId());
        Assert.assertEquals(, productVORead.getCreator());
        Assert.assertEquals(, productVORead.getUpdator());
        Assert.assertEquals(, productVORead.getProductVariantList());
        Assert.assertEquals(, productVORead.getProductOptionList());
        Assert.assertEquals(, productVORead.getProductImageList());
        Assert.assertEquals(, productVORead.getVendor());
        Assert.assertEquals(, productVORead.getProductUnit());
        Assert.assertEquals(, productVORead.getImageId());
        Assert.assertEquals(, productVORead.getBodyHtml());
        Assert.assertEquals(, productVORead.getImageSrc());
        Assert.assertEquals(, productVORead.getCategoryName());
        Assert.assertEquals(, productVORead.getDeletor());
        Assert.assertEquals(, productVORead.getProductSyncStateList());
        Assert.assertEquals(, productVORead.getSyncUpdatedAt());
        Assert.assertEquals(, productVORead.getFullCategoryName());
    }

    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testSave() throws Exception {
        ProductSaveVO productSaveVO = MockUtil.fromFile("product_save.json", ProductSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductVO productVOSaved = Printer.print(response, ProductVO.class);

        ProductVO productVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productVOSaved.getId());
        Assert.assertEquals(productSaveVO.getId(), productVORead.getId());
        Assert.assertEquals(productSaveVO.getMerchantId(), productVORead.getMerchantId());
        Assert.assertEquals(productSaveVO.getTitle(), productVORead.getTitle());
        Assert.assertEquals(productSaveVO.getProductTypeId(), productVORead.getProductTypeId());
        Assert.assertEquals(productSaveVO.getDeleted(), productVORead.getDeleted());
        Assert.assertEquals(productSaveVO.getCreatedAt(), productVORead.getCreatedAt());
        Assert.assertEquals(productSaveVO.getUpdatedAt(), productVORead.getUpdatedAt());
        Assert.assertEquals(productSaveVO.getDeletedAt(), productVORead.getDeletedAt());
        Assert.assertEquals(productSaveVO.getShorthandCharacter(), productVORead.getShorthandCharacter());
        Assert.assertEquals(productSaveVO.getFirstCharacter(), productVORead.getFirstCharacter());
        Assert.assertEquals(productSaveVO.getStopPurchaseIs(), productVORead.getStopPurchaseIs());
        Assert.assertEquals(productSaveVO.getDisuseIs(), productVORead.getDisuseIs());
        Assert.assertEquals(productSaveVO.getStopSellIs(), productVORead.getStopSellIs());
        Assert.assertEquals(productSaveVO.getSyncSource(), productVORead.getSyncSource());
        Assert.assertEquals(productSaveVO.getCategoryId(), productVORead.getCategoryId());
        Assert.assertEquals(productSaveVO.getCreator(), productVORead.getCreator());
        Assert.assertEquals(productSaveVO.getUpdator(), productVORead.getUpdator());
        Assert.assertEquals(productSaveVO.getProductVariantList(), productVORead.getProductVariantList());
        Assert.assertEquals(productSaveVO.getProductOptionList(), productVORead.getProductOptionList());
        Assert.assertEquals(productSaveVO.getProductImageList(), productVORead.getProductImageList());
        Assert.assertEquals(productSaveVO.getVendor(), productVORead.getVendor());
        Assert.assertEquals(productSaveVO.getProductUnit(), productVORead.getProductUnit());
        Assert.assertEquals(productSaveVO.getImageId(), productVORead.getImageId());
        Assert.assertEquals(productSaveVO.getBodyHtml(), productVORead.getBodyHtml());
        Assert.assertEquals(productSaveVO.getImageSrc(), productVORead.getImageSrc());
        Assert.assertEquals(productSaveVO.getCategoryName(), productVORead.getCategoryName());
        Assert.assertEquals(productSaveVO.getDeletor(), productVORead.getDeletor());
        Assert.assertEquals(productSaveVO.getProductSyncStateList(), productVORead.getProductSyncStateList());
        Assert.assertEquals(productSaveVO.getSyncUpdatedAt(), productVORead.getSyncUpdatedAt());
        Assert.assertEquals(productSaveVO.getFullCategoryName(), productVORead.getFullCategoryName());
    }

    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testUpdate() throws Exception {
        ProductSaveVO productSaveVO = MockUtil.fromFile("product_save.json", ProductSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductVO productVOSaved = Printer.print(response, ProductVO.class);

        ProductUpdateVO productUpdateVO = MockUtil.fromFile("product_update.json", ProductUpdateVO.class);
        productUpdateVO.setId(productVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, productUpdateVO, MockMvcResultMatchers.status().isOk());
        ProductVO productVOUpdated = Printer.print(response, ProductVO.class);
        Assert.assertEquals(productUpdateVO.getId(), productVOUpdated.getId());
        Assert.assertEquals(productUpdateVO.getMerchantId(), productVOUpdated.getMerchantId());
        Assert.assertEquals(productUpdateVO.getTitle(), productVOUpdated.getTitle());
        Assert.assertEquals(productUpdateVO.getProductTypeId(), productVOUpdated.getProductTypeId());
        Assert.assertEquals(productUpdateVO.getDeleted(), productVOUpdated.getDeleted());
        Assert.assertEquals(productUpdateVO.getCreatedAt(), productVOUpdated.getCreatedAt());
        Assert.assertEquals(productUpdateVO.getUpdatedAt(), productVOUpdated.getUpdatedAt());
        Assert.assertEquals(productUpdateVO.getDeletedAt(), productVOUpdated.getDeletedAt());
        Assert.assertEquals(productUpdateVO.getShorthandCharacter(), productVOUpdated.getShorthandCharacter());
        Assert.assertEquals(productUpdateVO.getFirstCharacter(), productVOUpdated.getFirstCharacter());
        Assert.assertEquals(productUpdateVO.getStopPurchaseIs(), productVOUpdated.getStopPurchaseIs());
        Assert.assertEquals(productUpdateVO.getDisuseIs(), productVOUpdated.getDisuseIs());
        Assert.assertEquals(productUpdateVO.getStopSellIs(), productVOUpdated.getStopSellIs());
        Assert.assertEquals(productUpdateVO.getSyncSource(), productVOUpdated.getSyncSource());
        Assert.assertEquals(productUpdateVO.getCategoryId(), productVOUpdated.getCategoryId());
        Assert.assertEquals(productUpdateVO.getCreator(), productVOUpdated.getCreator());
        Assert.assertEquals(productUpdateVO.getUpdator(), productVOUpdated.getUpdator());
        Assert.assertEquals(productUpdateVO.getProductVariantList(), productVOUpdated.getProductVariantList());
        Assert.assertEquals(productUpdateVO.getProductOptionList(), productVOUpdated.getProductOptionList());
        Assert.assertEquals(productUpdateVO.getProductImageList(), productVOUpdated.getProductImageList());
        Assert.assertEquals(productUpdateVO.getVendor(), productVOUpdated.getVendor());
        Assert.assertEquals(productUpdateVO.getProductUnit(), productVOUpdated.getProductUnit());
        Assert.assertEquals(productUpdateVO.getImageId(), productVOUpdated.getImageId());
        Assert.assertEquals(productUpdateVO.getBodyHtml(), productVOUpdated.getBodyHtml());
        Assert.assertEquals(productUpdateVO.getImageSrc(), productVOUpdated.getImageSrc());
        Assert.assertEquals(productUpdateVO.getCategoryName(), productVOUpdated.getCategoryName());
        Assert.assertEquals(productUpdateVO.getDeletor(), productVOUpdated.getDeletor());
        Assert.assertEquals(productUpdateVO.getProductSyncStateList(), productVOUpdated.getProductSyncStateList());
        Assert.assertEquals(productUpdateVO.getSyncUpdatedAt(), productVOUpdated.getSyncUpdatedAt());
        Assert.assertEquals(productUpdateVO.getFullCategoryName(), productVOUpdated.getFullCategoryName());

        ProductVO productVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productVOSaved.getId());
        Assert.assertEquals(productUpdateVO.getId(), productVORead.getId());
        Assert.assertEquals(productUpdateVO.getMerchantId(), productVORead.getMerchantId());
        Assert.assertEquals(productUpdateVO.getTitle(), productVORead.getTitle());
        Assert.assertEquals(productUpdateVO.getProductTypeId(), productVORead.getProductTypeId());
        Assert.assertEquals(productUpdateVO.getDeleted(), productVORead.getDeleted());
        Assert.assertEquals(productUpdateVO.getCreatedAt(), productVORead.getCreatedAt());
        Assert.assertEquals(productUpdateVO.getUpdatedAt(), productVORead.getUpdatedAt());
        Assert.assertEquals(productUpdateVO.getDeletedAt(), productVORead.getDeletedAt());
        Assert.assertEquals(productUpdateVO.getShorthandCharacter(), productVORead.getShorthandCharacter());
        Assert.assertEquals(productUpdateVO.getFirstCharacter(), productVORead.getFirstCharacter());
        Assert.assertEquals(productUpdateVO.getStopPurchaseIs(), productVORead.getStopPurchaseIs());
        Assert.assertEquals(productUpdateVO.getDisuseIs(), productVORead.getDisuseIs());
        Assert.assertEquals(productUpdateVO.getStopSellIs(), productVORead.getStopSellIs());
        Assert.assertEquals(productUpdateVO.getSyncSource(), productVORead.getSyncSource());
        Assert.assertEquals(productUpdateVO.getCategoryId(), productVORead.getCategoryId());
        Assert.assertEquals(productUpdateVO.getCreator(), productVORead.getCreator());
        Assert.assertEquals(productUpdateVO.getUpdator(), productVORead.getUpdator());
        Assert.assertEquals(productUpdateVO.getProductVariantList(), productVORead.getProductVariantList());
        Assert.assertEquals(productUpdateVO.getProductOptionList(), productVORead.getProductOptionList());
        Assert.assertEquals(productUpdateVO.getProductImageList(), productVORead.getProductImageList());
        Assert.assertEquals(productUpdateVO.getVendor(), productVORead.getVendor());
        Assert.assertEquals(productUpdateVO.getProductUnit(), productVORead.getProductUnit());
        Assert.assertEquals(productUpdateVO.getImageId(), productVORead.getImageId());
        Assert.assertEquals(productUpdateVO.getBodyHtml(), productVORead.getBodyHtml());
        Assert.assertEquals(productUpdateVO.getImageSrc(), productVORead.getImageSrc());
        Assert.assertEquals(productUpdateVO.getCategoryName(), productVORead.getCategoryName());
        Assert.assertEquals(productUpdateVO.getDeletor(), productVORead.getDeletor());
        Assert.assertEquals(productUpdateVO.getProductSyncStateList(), productVORead.getProductSyncStateList());
        Assert.assertEquals(productUpdateVO.getSyncUpdatedAt(), productVORead.getSyncUpdatedAt());
        Assert.assertEquals(productUpdateVO.getFullCategoryName(), productVORead.getFullCategoryName());
    }

    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testDelete() throws Exception {
        ProductSaveVO productSaveVO = MockUtil.fromFile("product_save.json", ProductSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, productSaveVO, MockMvcResultMatchers.status().isCreated());
        ProductVO productVOSaved = Printer.print(response, ProductVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, productVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        ProductVO product = read(ConstantsTest.HUAJY_MERCHANT_ID_1, productVOSaved.getId());
        Assert.assertEquals(null, product);
    }

    /**
    * 测试按条件查询商品.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/products.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("id_list", "")
                    .param("query_name", "")
                    .param("sync_source", "")
                    .param("category_id_list", "")
                    .param("stop_sell_is", "")
                    .param("stop_purchase_is", "")
                    .param("disuse_is", "")
                    .param("with_variant_is", "")
                    .param("product_state_list", "")
                    .param("product_sync_state_list", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("sort_order", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVO>>() {}.getType();
    List<ProductVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试新增商品图片.
    *
    * @throws Exception 异常
    */
    @Test
    public void testSaveImage() throws Exception {
        String url = BASE_URL + "/products/images.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试按条件查询商品规格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariant() throws Exception {
        String url = BASE_URL + "/products/variants.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("query_name", "")
                    .param("sync_source", "")
                    .param("category_id_list", "")
                    .param("id_list", "")
                    .param("stop_sell_is", "")
                    .param("stop_purchase_is", "")
                    .param("disuse_is", "")
                    .param("product_state_list", "")
                    .param("query_deleted_is", "")
                    .param("with_unit_is", "")
                    .param("with_category_is", "")
                    .param("exclude_id_list", "")
                    .param("process_type", "")
                    .param("sort_order", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("field_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantVO>>() {}.getType();
    List<ProductVariantVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试查询商品规格价格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantPrice() throws Exception {
        String url = BASE_URL + "/products/variants/price.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("variant_id_list", "")
                    .param("storehouse_id", "")
                    .param("price_type_list", "")
                    .param("location_id", "")
                    .param("other_storehouse_id", "")
                    .param("other_location_id", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantPriceVO>>() {}.getType();
    List<ProductVariantPriceVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试查询商品规格价格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantPrice() throws Exception {
        ProductVariantPriceQueryVO productVariantPriceQueryVO = new ProductVariantPriceQueryVO();
        productVariantPriceQueryVO.setVariantIdList();
        productVariantPriceQueryVO.setStorehouseId();
        productVariantPriceQueryVO.setLocationId();
        productVariantPriceQueryVO.setOtherStorehouseId();
        productVariantPriceQueryVO.setOtherLocationId();
        productVariantPriceQueryVO.setPriceTypeList();

        String url = BASE_URL + "/products/variants/price.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productVariantPriceQueryVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantPriceVO>>() {}.getType();
    List<ProductVariantPriceVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据商品id集合查询商品单位.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListUnitByIdList() throws Exception {
        String url = BASE_URL + "/products/list_unit_by_id_list.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("id_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductUnitVO>>() {}.getType();
    List<ProductUnitVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据规格id集合查询规格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantByVariantIdList() throws Exception {
        String url = BASE_URL + "/products/list_variant_by_variant_id_list.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("variant_id_list", "")
                    .param("with_property_is", "")
                    .param("field_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantVO>>() {}.getType();
    List<ProductVariantVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据规格id集合查询规格(POST请求).
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantByVariantIdList() throws Exception {
        ProductVariantListByIdListQueryVO productVariantListByIdListQueryVO = new ProductVariantListByIdListQueryVO();

        String url = BASE_URL + "/products/list_variant_by_variant_id_list.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productVariantListByIdListQueryVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantVO>>() {}.getType();
    List<ProductVariantVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试批量更新产品类别.
    *
    * @throws Exception 异常
    */
    @Test
    public void testBatchUpdateCategory() throws Exception {
        ProductBatchUpdateCategoryVO productBatchUpdateCategoryVO = new ProductBatchUpdateCategoryVO();
        productBatchUpdateCategoryVO.setIdList();
        productBatchUpdateCategoryVO.setCategoryId();

        String url = BASE_URL + "/products/batch_update_category.json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productBatchUpdateCategoryVO))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试按商品id集合查询商品.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListByIdList() throws Exception {
        String url = BASE_URL + "/products/list_by_id_list.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("id_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVO>>() {}.getType();
    List<ProductVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试按条件查询商品规格id.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantId() throws Exception {
        String url = BASE_URL + "/products/list_variants_id.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("query_name", "")
                    .param("sync_source", "")
                    .param("category_id_list", "")
                    .param("id_list", "")
                    .param("stop_sell_is", "")
                    .param("stop_purchase_is", "")
                    .param("disuse_is", "")
                    .param("product_state_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<BigInteger>>() {}.getType();
    List<BigInteger> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试查询删除的规格id集合.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListDeletdVariantId() throws Exception {
        String url = BASE_URL + "/products/list_deleted_variants_id.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<BigInteger>>() {}.getType();
    List<BigInteger> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试导入商品excel.
    *
    * @throws Exception 异常
    */
    @Test
    public void testImportExcel() throws Exception {
        String url = BASE_URL + "/products/import.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("staff_id", "")
                    .param("location_id", "")
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试校验sku和条码是否被使用.
    *
    * @throws Exception 异常
    */
    @Test
    public void testCheckSkuAndBarcode() throws Exception {
        List<ProductVariantCheckSkuAndBarcodeCheckVO> productVariantCheckSkuAndBarcodeCheckVOList = new List<ProductVariantCheckSkuAndBarcodeCheckVO>();
        productVariantCheckSkuAndBarcodeCheckVOList.setProductVariantId();
        productVariantCheckSkuAndBarcodeCheckVOList.setSku();
        productVariantCheckSkuAndBarcodeCheckVOList.setBarcodeList();

        String url = BASE_URL + "/products/variants/check_sku_and_barcode.json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productVariantCheckSkuAndBarcodeCheckVOList))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试按条件查询商品(返回关联属性).
    *
    * @throws Exception 异常
    */
    @Test
    public void testListWithProperties() throws Exception {
        String url = BASE_URL + "/products/list_with_properties.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("id_list", "")
                    .param("query_name", "")
                    .param("sync_source", "")
                    .param("category_id_list", "")
                    .param("stop_sell_is", "")
                    .param("stop_purchase_is", "")
                    .param("disuse_is", "")
                    .param("barcode", "")
                    .param("with_variant_is", "")
                    .param("product_state_list", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("storehouse_id", "")
                    .param("location_id", "")
                    .param("other_storehouse_id", "")
                    .param("other_location_id", "")
                    .param("price_type_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVO>>() {}.getType();
    List<ProductVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试导出商品Excel.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExport() throws Exception {
        ProductExportVO productExportVO = new ProductExportVO();
        productExportVO.setCategoryIdList();
        productExportVO.setCategoryNameList();
        productExportVO.setStopSellIs();
        productExportVO.setStopPurchaseIs();
        productExportVO.setDisuseIs();
        productExportVO.setProductStateList();
        productExportVO.setProductSyncStateList();
        productExportVO.setSyncSource();
        productExportVO.setQueryName();
        productExportVO.setSortOrder();
        productExportVO.setGridHeaderList();
        productExportVO.setStaffId();
        productExportVO.setLocationId();

        String url = BASE_URL + "/products/export.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试按条件查询商品(同步).
    *
    * @throws Exception 异常
    */
    @Test
    public void testListForSync() throws Exception {
        String url = BASE_URL + "/products/sync.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("sync_updated_at_min", "")
                    .param("offset", "")
                    .param("limit", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVO>>() {}.getType();
    List<ProductVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据商品标题和规格标题查询规格.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListVariantByProductTitleAndVariantTitleList() throws Exception {
        String url = BASE_URL + "/products/list_variant_by_product_title_and_variant_title_list.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("product_title_list", "")
                    .param("variant_title_list", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProductVariantVO>>() {}.getType();
    List<ProductVariantVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试批量更新商品.
    *
    * @throws Exception 异常
    */
    @Test
    public void testBatchUpdate() throws Exception {
        ProductBatchUpdateVO productBatchUpdateVO = new ProductBatchUpdateVO();
        productBatchUpdateVO.setIdList();
        productBatchUpdateVO.setCategoryIdList();
        productBatchUpdateVO.setUpdateCategoryIdIs();
        productBatchUpdateVO.setCategoryId();
        productBatchUpdateVO.setUpdateProductUnitIs();
        productBatchUpdateVO.setProductUnit();
        productBatchUpdateVO.setUpdateStopPurchaseIs();
        productBatchUpdateVO.setStopPurchaseIs();
        productBatchUpdateVO.setUpdateStopSellIs();
        productBatchUpdateVO.setStopSellIs();
        productBatchUpdateVO.setUpdateDisuseIs();
        productBatchUpdateVO.setDisuseIs();

        String url = BASE_URL + "/products/batch_update.json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(productBatchUpdateVO))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }


    /**
    * 读取.
    *
    * @param merchantId 商户id
    * @param id id
    * @return 返回对象
    */
    private ProductVO read(final BigInteger merchantId, final BigInteger id) throws Exception {
        String url = BASE_URL + "/products/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, ProductVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final ProductSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/products.json";
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
    private MockHttpServletResponse update(final BigInteger merchantId, final ProductUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/products.json";
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
        String url = BASE_URL + "/products/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.delete(url)
        .contentType(MediaType.APPLICATION_JSON)
        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
        .andExpect(resultMatcher)
        .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse;
    }
}
