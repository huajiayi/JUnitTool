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
* ProduceStorageOrderController单元测试.
*
* @author nhsoft.huajy
*/
@Transactional
public class ProduceStorageOrderControllerTest extends BaseTest {

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
        ProduceStorageOrderVO produceStorageOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, produceStorageOrderVORead.getId());
        Assert.assertEquals(, produceStorageOrderVORead.getOrderNo());
        Assert.assertEquals(, produceStorageOrderVORead.getMerchantId());
        Assert.assertEquals(, produceStorageOrderVORead.getCreateLocationId());
        Assert.assertEquals(, produceStorageOrderVORead.getLocationId());
        Assert.assertEquals(, produceStorageOrderVORead.getStorehouseId());
        Assert.assertEquals(, produceStorageOrderVORead.getStoragedAt());
        Assert.assertEquals(, produceStorageOrderVORead.getStateCode());
        Assert.assertEquals(, produceStorageOrderVORead.getStateName());
        Assert.assertEquals(, produceStorageOrderVORead.getMoney());
        Assert.assertEquals(, produceStorageOrderVORead.getCreatedSource());
        Assert.assertEquals(, produceStorageOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(, produceStorageOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(, produceStorageOrderVORead.getBizday());
        Assert.assertEquals(, produceStorageOrderVORead.getMemo());
        Assert.assertEquals(, produceStorageOrderVORead.getCreator());
        Assert.assertEquals(, produceStorageOrderVORead.getCreatedAt());
        Assert.assertEquals(, produceStorageOrderVORead.getAuditor());
        Assert.assertEquals(, produceStorageOrderVORead.getAuditedAt());
        Assert.assertEquals(, produceStorageOrderVORead.getCancelor());
        Assert.assertEquals(, produceStorageOrderVORead.getCanceledAt());
        Assert.assertEquals(, produceStorageOrderVORead.getUpdator());
        Assert.assertEquals(, produceStorageOrderVORead.getUpdatedAt());
        Assert.assertEquals(, produceStorageOrderVORead.getRoundMoney());
        Assert.assertEquals(, produceStorageOrderVORead.getProduceStorageOrderDetailList());
        Assert.assertEquals(, produceStorageOrderVORead.getStorehouseName());
        Assert.assertEquals(, produceStorageOrderVORead.getLocationName());
    }

    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testSave() throws Exception {
        ProduceStorageOrderSaveVO produceStorageOrderSaveVO = MockUtil.fromFile("produce_storage_order_save.json", ProduceStorageOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        ProduceStorageOrderVO produceStorageOrderVOSaved = Printer.print(response, ProduceStorageOrderVO.class);

        ProduceStorageOrderVO produceStorageOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderVOSaved.getId());
        Assert.assertEquals(produceStorageOrderSaveVO.getId(), produceStorageOrderVORead.getId());
        Assert.assertEquals(produceStorageOrderSaveVO.getOrderNo(), produceStorageOrderVORead.getOrderNo());
        Assert.assertEquals(produceStorageOrderSaveVO.getMerchantId(), produceStorageOrderVORead.getMerchantId());
        Assert.assertEquals(produceStorageOrderSaveVO.getCreateLocationId(), produceStorageOrderVORead.getCreateLocationId());
        Assert.assertEquals(produceStorageOrderSaveVO.getLocationId(), produceStorageOrderVORead.getLocationId());
        Assert.assertEquals(produceStorageOrderSaveVO.getStorehouseId(), produceStorageOrderVORead.getStorehouseId());
        Assert.assertEquals(produceStorageOrderSaveVO.getStoragedAt(), produceStorageOrderVORead.getStoragedAt());
        Assert.assertEquals(produceStorageOrderSaveVO.getStateCode(), produceStorageOrderVORead.getStateCode());
        Assert.assertEquals(produceStorageOrderSaveVO.getStateName(), produceStorageOrderVORead.getStateName());
        Assert.assertEquals(produceStorageOrderSaveVO.getMoney(), produceStorageOrderVORead.getMoney());
        Assert.assertEquals(produceStorageOrderSaveVO.getCreatedSource(), produceStorageOrderVORead.getCreatedSource());
        Assert.assertEquals(produceStorageOrderSaveVO.getSalesmanStaffName(), produceStorageOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(produceStorageOrderSaveVO.getSalesmanStaffId(), produceStorageOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(produceStorageOrderSaveVO.getBizday(), produceStorageOrderVORead.getBizday());
        Assert.assertEquals(produceStorageOrderSaveVO.getMemo(), produceStorageOrderVORead.getMemo());
        Assert.assertEquals(produceStorageOrderSaveVO.getCreator(), produceStorageOrderVORead.getCreator());
        Assert.assertEquals(produceStorageOrderSaveVO.getCreatedAt(), produceStorageOrderVORead.getCreatedAt());
        Assert.assertEquals(produceStorageOrderSaveVO.getAuditor(), produceStorageOrderVORead.getAuditor());
        Assert.assertEquals(produceStorageOrderSaveVO.getAuditedAt(), produceStorageOrderVORead.getAuditedAt());
        Assert.assertEquals(produceStorageOrderSaveVO.getCancelor(), produceStorageOrderVORead.getCancelor());
        Assert.assertEquals(produceStorageOrderSaveVO.getCanceledAt(), produceStorageOrderVORead.getCanceledAt());
        Assert.assertEquals(produceStorageOrderSaveVO.getUpdator(), produceStorageOrderVORead.getUpdator());
        Assert.assertEquals(produceStorageOrderSaveVO.getUpdatedAt(), produceStorageOrderVORead.getUpdatedAt());
        Assert.assertEquals(produceStorageOrderSaveVO.getRoundMoney(), produceStorageOrderVORead.getRoundMoney());
        Assert.assertEquals(produceStorageOrderSaveVO.getProduceStorageOrderDetailList(), produceStorageOrderVORead.getProduceStorageOrderDetailList());
        Assert.assertEquals(produceStorageOrderSaveVO.getStorehouseName(), produceStorageOrderVORead.getStorehouseName());
        Assert.assertEquals(produceStorageOrderSaveVO.getLocationName(), produceStorageOrderVORead.getLocationName());
    }

    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testUpdate() throws Exception {
        ProduceStorageOrderSaveVO produceStorageOrderSaveVO = MockUtil.fromFile("produce_storage_order_save.json", ProduceStorageOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        ProduceStorageOrderVO produceStorageOrderVOSaved = Printer.print(response, ProduceStorageOrderVO.class);

        ProduceStorageOrderUpdateVO produceStorageOrderUpdateVO = MockUtil.fromFile("produce_storage_order_update.json", ProduceStorageOrderUpdateVO.class);
        produceStorageOrderUpdateVO.setId(produceStorageOrderVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderUpdateVO, MockMvcResultMatchers.status().isOk());
        ProduceStorageOrderVO produceStorageOrderVOUpdated = Printer.print(response, ProduceStorageOrderVO.class);
        Assert.assertEquals(produceStorageOrderUpdateVO.getId(), produceStorageOrderVOUpdated.getId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getOrderNo(), produceStorageOrderVOUpdated.getOrderNo());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMerchantId(), produceStorageOrderVOUpdated.getMerchantId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreateLocationId(), produceStorageOrderVOUpdated.getCreateLocationId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getLocationId(), produceStorageOrderVOUpdated.getLocationId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStorehouseId(), produceStorageOrderVOUpdated.getStorehouseId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStoragedAt(), produceStorageOrderVOUpdated.getStoragedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStateCode(), produceStorageOrderVOUpdated.getStateCode());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStateName(), produceStorageOrderVOUpdated.getStateName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMoney(), produceStorageOrderVOUpdated.getMoney());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreatedSource(), produceStorageOrderVOUpdated.getCreatedSource());
        Assert.assertEquals(produceStorageOrderUpdateVO.getSalesmanStaffName(), produceStorageOrderVOUpdated.getSalesmanStaffName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getSalesmanStaffId(), produceStorageOrderVOUpdated.getSalesmanStaffId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getBizday(), produceStorageOrderVOUpdated.getBizday());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMemo(), produceStorageOrderVOUpdated.getMemo());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreator(), produceStorageOrderVOUpdated.getCreator());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreatedAt(), produceStorageOrderVOUpdated.getCreatedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getAuditor(), produceStorageOrderVOUpdated.getAuditor());
        Assert.assertEquals(produceStorageOrderUpdateVO.getAuditedAt(), produceStorageOrderVOUpdated.getAuditedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCancelor(), produceStorageOrderVOUpdated.getCancelor());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCanceledAt(), produceStorageOrderVOUpdated.getCanceledAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getUpdator(), produceStorageOrderVOUpdated.getUpdator());
        Assert.assertEquals(produceStorageOrderUpdateVO.getUpdatedAt(), produceStorageOrderVOUpdated.getUpdatedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getRoundMoney(), produceStorageOrderVOUpdated.getRoundMoney());
        Assert.assertEquals(produceStorageOrderUpdateVO.getProduceStorageOrderDetailList(), produceStorageOrderVOUpdated.getProduceStorageOrderDetailList());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStorehouseName(), produceStorageOrderVOUpdated.getStorehouseName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getLocationName(), produceStorageOrderVOUpdated.getLocationName());

        ProduceStorageOrderVO produceStorageOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderVOSaved.getId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getId(), produceStorageOrderVORead.getId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getOrderNo(), produceStorageOrderVORead.getOrderNo());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMerchantId(), produceStorageOrderVORead.getMerchantId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreateLocationId(), produceStorageOrderVORead.getCreateLocationId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getLocationId(), produceStorageOrderVORead.getLocationId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStorehouseId(), produceStorageOrderVORead.getStorehouseId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStoragedAt(), produceStorageOrderVORead.getStoragedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStateCode(), produceStorageOrderVORead.getStateCode());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStateName(), produceStorageOrderVORead.getStateName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMoney(), produceStorageOrderVORead.getMoney());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreatedSource(), produceStorageOrderVORead.getCreatedSource());
        Assert.assertEquals(produceStorageOrderUpdateVO.getSalesmanStaffName(), produceStorageOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getSalesmanStaffId(), produceStorageOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(produceStorageOrderUpdateVO.getBizday(), produceStorageOrderVORead.getBizday());
        Assert.assertEquals(produceStorageOrderUpdateVO.getMemo(), produceStorageOrderVORead.getMemo());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreator(), produceStorageOrderVORead.getCreator());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCreatedAt(), produceStorageOrderVORead.getCreatedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getAuditor(), produceStorageOrderVORead.getAuditor());
        Assert.assertEquals(produceStorageOrderUpdateVO.getAuditedAt(), produceStorageOrderVORead.getAuditedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCancelor(), produceStorageOrderVORead.getCancelor());
        Assert.assertEquals(produceStorageOrderUpdateVO.getCanceledAt(), produceStorageOrderVORead.getCanceledAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getUpdator(), produceStorageOrderVORead.getUpdator());
        Assert.assertEquals(produceStorageOrderUpdateVO.getUpdatedAt(), produceStorageOrderVORead.getUpdatedAt());
        Assert.assertEquals(produceStorageOrderUpdateVO.getRoundMoney(), produceStorageOrderVORead.getRoundMoney());
        Assert.assertEquals(produceStorageOrderUpdateVO.getProduceStorageOrderDetailList(), produceStorageOrderVORead.getProduceStorageOrderDetailList());
        Assert.assertEquals(produceStorageOrderUpdateVO.getStorehouseName(), produceStorageOrderVORead.getStorehouseName());
        Assert.assertEquals(produceStorageOrderUpdateVO.getLocationName(), produceStorageOrderVORead.getLocationName());
    }

    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testDelete() throws Exception {
        ProduceStorageOrderSaveVO produceStorageOrderSaveVO = MockUtil.fromFile("produce_storage_order_save.json", ProduceStorageOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        ProduceStorageOrderVO produceStorageOrderVOSaved = Printer.print(response, ProduceStorageOrderVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        ProduceStorageOrderVO produceStorageOrder = read(ConstantsTest.HUAJY_MERCHANT_ID_1, produceStorageOrderVOSaved.getId());
        Assert.assertEquals(null, produceStorageOrder);
    }

    /**
    * 测试审核生产入库单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testAudit() throws Exception {
        ProduceStorageOrderAuditVO produceStorageOrderAuditVO = new ProduceStorageOrderAuditVO();
        produceStorageOrderAuditVO.setId();
        produceStorageOrderAuditVO.setOrderNo();
        produceStorageOrderAuditVO.setLocationId();
        produceStorageOrderAuditVO.setStorehouseId();
        produceStorageOrderAuditVO.setMemo();
        produceStorageOrderAuditVO.setMoney();
        produceStorageOrderAuditVO.setSalesmanStaffName();
        produceStorageOrderAuditVO.setSalesmanStaffId();
        produceStorageOrderAuditVO.setRoundMoney();
        produceStorageOrderAuditVO.setStoragedAt();
        produceStorageOrderAuditVO.setProduceStorageOrderDetailList();
        produceStorageOrderAuditVO.setLocationName();
        produceStorageOrderAuditVO.setStorehouseName();

        String url = BASE_URL + "/produce_storage_orders/audit.json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(produceStorageOrderAuditVO))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试作废生产入库单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testCancel() throws Exception {
        BigInteger id = ;

        String url = BASE_URL + "/produce_storage_orders/cancel/" + id + ".json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试生产入库单列表.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/produce_storage_orders.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("date_type", "")
                    .param("date_min", "")
                    .param("date_max", "")
                    .param("location_id_list", "")
                    .param("storehouse_id_list", "")
                    .param("order_state", "")
                    .param("order_no", "")
                    .param("with_detail_is", "")
                    .param("salesman_staff_id_list", "")
                    .param("query_name", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("sort_order", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<ProduceStorageOrderVO>>() {}.getType();
    List<ProduceStorageOrderVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据id审核生产入库单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testAuditById() throws Exception {
        BigInteger id = ;

        String url = BASE_URL + "/produce_storage_orders/audit/" + id + ".json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试新增并审核生产入库单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testSaveAndAudit() throws Exception {
        ProduceStorageOrderSaveVO produceStorageOrderSaveVO = new ProduceStorageOrderSaveVO();
        produceStorageOrderSaveVO.setCreateLocationId();
        produceStorageOrderSaveVO.setLocationId();
        produceStorageOrderSaveVO.setStorehouseId();
        produceStorageOrderSaveVO.setMemo();
        produceStorageOrderSaveVO.setMoney();
        produceStorageOrderSaveVO.setCreatedSource();
        produceStorageOrderSaveVO.setSalesmanStaffName();
        produceStorageOrderSaveVO.setSalesmanStaffId();
        produceStorageOrderSaveVO.setRoundMoney();
        produceStorageOrderSaveVO.setStoragedAt();
        produceStorageOrderSaveVO.setProduceStorageOrderDetailList();
        produceStorageOrderSaveVO.setLocationName();
        produceStorageOrderSaveVO.setStorehouseName();

        String url = BASE_URL + "/produce_storage_orders/save_and_audit.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(produceStorageOrderSaveVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试导出生产入库单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExport() throws Exception {
        ProduceStorageOrderExportVO produceStorageOrderExportVO = new ProduceStorageOrderExportVO();
        produceStorageOrderExportVO.setDateType();
        produceStorageOrderExportVO.setDateMin();
        produceStorageOrderExportVO.setDateMax();
        produceStorageOrderExportVO.setLocationIdList();
        produceStorageOrderExportVO.setStorehouseIdList();
        produceStorageOrderExportVO.setStorehouseNameList();
        produceStorageOrderExportVO.setStateCode();
        produceStorageOrderExportVO.setOrderNo();
        produceStorageOrderExportVO.setSalesmanStaffIdList();
        produceStorageOrderExportVO.setSalesmanStaffNameList();
        produceStorageOrderExportVO.setSortOrder();
        produceStorageOrderExportVO.setGridHeaderList();
        produceStorageOrderExportVO.setStaffId();
        produceStorageOrderExportVO.setLocationId();

        String url = BASE_URL + "/produce_storage_orders/export.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(produceStorageOrderExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试导出生产入库单明细.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExportDetail() throws Exception {
        ProduceStorageOrderDetailExportVO produceStorageOrderDetailExportVO = new ProduceStorageOrderDetailExportVO();
        produceStorageOrderDetailExportVO.setOrderId();
        produceStorageOrderDetailExportVO.setOrderNo();
        produceStorageOrderDetailExportVO.setGridHeaderList();
        produceStorageOrderDetailExportVO.setStaffId();
        produceStorageOrderDetailExportVO.setLocationId();

        String url = BASE_URL + "/produce_storage_orders/export_detail.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(produceStorageOrderDetailExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试出品率报表统计.
    *
    * @throws Exception 异常
    */
    @Test
    public void testListFinishedStorageRateReport() throws Exception {
        String url = BASE_URL + "/produce_storage_orders/finished_storage_rate_report.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("location_id_list", "")
                    .param("date_type", "")
                    .param("date_min", "")
                    .param("date_max", "")
                    .param("plan_order_id_list", "")
                    .param("product_variant_id_list", "")
                    .param("product_query_name", "")
                    .param("category_id_list", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("sort_order", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<FinishedStorageRateReportVO>>() {}.getType();
    List<FinishedStorageRateReportVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试导出出品率报表.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExportFinishedStorageRateReport() throws Exception {
        FinishedStorageRateReportExportVO finishedStorageRateReportExportVO = new FinishedStorageRateReportExportVO();
        finishedStorageRateReportExportVO.setDateType();
        finishedStorageRateReportExportVO.setDateMin();
        finishedStorageRateReportExportVO.setDateMax();
        finishedStorageRateReportExportVO.setLocationIdList();
        finishedStorageRateReportExportVO.setProductQueryName();
        finishedStorageRateReportExportVO.setProductVariantIdList();
        finishedStorageRateReportExportVO.setPlanOrderIdList();
        finishedStorageRateReportExportVO.setCategoryIdList();
        finishedStorageRateReportExportVO.setSortOrder();
        finishedStorageRateReportExportVO.setGridHeaderList();
        finishedStorageRateReportExportVO.setStaffId();
        finishedStorageRateReportExportVO.setLocationId();

        String url = BASE_URL + "/produce_storage_orders/export_finished_storage_rate_report.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(finishedStorageRateReportExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }


    /**
    * 读取.
    *
    * @param merchantId 商户id
    * @param id id
    * @return 返回对象
    */
    private ProduceStorageOrderVO read(final BigInteger merchantId, final BigInteger id) throws Exception {
        String url = BASE_URL + "/produce_storage_orders/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, ProduceStorageOrderVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final ProduceStorageOrderSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/produce_storage_orders.json";
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
    private MockHttpServletResponse update(final BigInteger merchantId, final ProduceStorageOrderUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/produce_storage_orders.json";
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
        String url = BASE_URL + "/produce_storage_orders/" + id + ".json";
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
