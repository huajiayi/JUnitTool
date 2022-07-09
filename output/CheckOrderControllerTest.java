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
* CheckOrderController单元测试.
*
* @author nhsoft.huajy
*/
@Transactional
public class CheckOrderControllerTest extends BaseTest {

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
        CheckOrderVO checkOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, checkOrderVORead.getId());
        Assert.assertEquals(, checkOrderVORead.getOrderNo());
        Assert.assertEquals(, checkOrderVORead.getMerchantId());
        Assert.assertEquals(, checkOrderVORead.getCreateLocationId());
        Assert.assertEquals(, checkOrderVORead.getLocationId());
        Assert.assertEquals(, checkOrderVORead.getStorehouseId());
        Assert.assertEquals(, checkOrderVORead.getCheckedAt());
        Assert.assertEquals(, checkOrderVORead.getStateCode());
        Assert.assertEquals(, checkOrderVORead.getStateName());
        Assert.assertEquals(, checkOrderVORead.getMoney());
        Assert.assertEquals(, checkOrderVORead.getSource());
        Assert.assertEquals(, checkOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(, checkOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(, checkOrderVORead.getBizday());
        Assert.assertEquals(, checkOrderVORead.getMemo());
        Assert.assertEquals(, checkOrderVORead.getCreatedAt());
        Assert.assertEquals(, checkOrderVORead.getCreator());
        Assert.assertEquals(, checkOrderVORead.getUpdatedAt());
        Assert.assertEquals(, checkOrderVORead.getUpdator());
        Assert.assertEquals(, checkOrderVORead.getAuditedAt());
        Assert.assertEquals(, checkOrderVORead.getAuditor());
        Assert.assertEquals(, checkOrderVORead.getCanceledAt());
        Assert.assertEquals(, checkOrderVORead.getCancelor());
        Assert.assertEquals(, checkOrderVORead.getRoundMoney());
        Assert.assertEquals(, checkOrderVORead.getCheckOrderType());
        Assert.assertEquals(, checkOrderVORead.getFilterStopPurchaseIs());
        Assert.assertEquals(, checkOrderVORead.getFilterDisuseIs());
        Assert.assertEquals(, checkOrderVORead.getFilterStopSellIs());
        Assert.assertEquals(, checkOrderVORead.getSnapshotIs());
        Assert.assertEquals(, checkOrderVORead.getSnapshotedAt());
        Assert.assertEquals(, checkOrderVORead.getBlindCheckIs());
        Assert.assertEquals(, checkOrderVORead.getCheckOrderDetailList());
        Assert.assertEquals(, checkOrderVORead.getLocationName());
        Assert.assertEquals(, checkOrderVORead.getStorehouseName());
        Assert.assertEquals(, checkOrderVORead.getCategoryIdList());
    }

    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testSave() throws Exception {
        CheckOrderSaveVO checkOrderSaveVO = MockUtil.fromFile("check_order_save.json", CheckOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        CheckOrderVO checkOrderVOSaved = Printer.print(response, CheckOrderVO.class);

        CheckOrderVO checkOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderVOSaved.getId());
        Assert.assertEquals(checkOrderSaveVO.getId(), checkOrderVORead.getId());
        Assert.assertEquals(checkOrderSaveVO.getOrderNo(), checkOrderVORead.getOrderNo());
        Assert.assertEquals(checkOrderSaveVO.getMerchantId(), checkOrderVORead.getMerchantId());
        Assert.assertEquals(checkOrderSaveVO.getCreateLocationId(), checkOrderVORead.getCreateLocationId());
        Assert.assertEquals(checkOrderSaveVO.getLocationId(), checkOrderVORead.getLocationId());
        Assert.assertEquals(checkOrderSaveVO.getStorehouseId(), checkOrderVORead.getStorehouseId());
        Assert.assertEquals(checkOrderSaveVO.getCheckedAt(), checkOrderVORead.getCheckedAt());
        Assert.assertEquals(checkOrderSaveVO.getStateCode(), checkOrderVORead.getStateCode());
        Assert.assertEquals(checkOrderSaveVO.getStateName(), checkOrderVORead.getStateName());
        Assert.assertEquals(checkOrderSaveVO.getMoney(), checkOrderVORead.getMoney());
        Assert.assertEquals(checkOrderSaveVO.getSource(), checkOrderVORead.getSource());
        Assert.assertEquals(checkOrderSaveVO.getSalesmanStaffName(), checkOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(checkOrderSaveVO.getSalesmanStaffId(), checkOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(checkOrderSaveVO.getBizday(), checkOrderVORead.getBizday());
        Assert.assertEquals(checkOrderSaveVO.getMemo(), checkOrderVORead.getMemo());
        Assert.assertEquals(checkOrderSaveVO.getCreatedAt(), checkOrderVORead.getCreatedAt());
        Assert.assertEquals(checkOrderSaveVO.getCreator(), checkOrderVORead.getCreator());
        Assert.assertEquals(checkOrderSaveVO.getUpdatedAt(), checkOrderVORead.getUpdatedAt());
        Assert.assertEquals(checkOrderSaveVO.getUpdator(), checkOrderVORead.getUpdator());
        Assert.assertEquals(checkOrderSaveVO.getAuditedAt(), checkOrderVORead.getAuditedAt());
        Assert.assertEquals(checkOrderSaveVO.getAuditor(), checkOrderVORead.getAuditor());
        Assert.assertEquals(checkOrderSaveVO.getCanceledAt(), checkOrderVORead.getCanceledAt());
        Assert.assertEquals(checkOrderSaveVO.getCancelor(), checkOrderVORead.getCancelor());
        Assert.assertEquals(checkOrderSaveVO.getRoundMoney(), checkOrderVORead.getRoundMoney());
        Assert.assertEquals(checkOrderSaveVO.getCheckOrderType(), checkOrderVORead.getCheckOrderType());
        Assert.assertEquals(checkOrderSaveVO.getFilterStopPurchaseIs(), checkOrderVORead.getFilterStopPurchaseIs());
        Assert.assertEquals(checkOrderSaveVO.getFilterDisuseIs(), checkOrderVORead.getFilterDisuseIs());
        Assert.assertEquals(checkOrderSaveVO.getFilterStopSellIs(), checkOrderVORead.getFilterStopSellIs());
        Assert.assertEquals(checkOrderSaveVO.getSnapshotIs(), checkOrderVORead.getSnapshotIs());
        Assert.assertEquals(checkOrderSaveVO.getSnapshotedAt(), checkOrderVORead.getSnapshotedAt());
        Assert.assertEquals(checkOrderSaveVO.getBlindCheckIs(), checkOrderVORead.getBlindCheckIs());
        Assert.assertEquals(checkOrderSaveVO.getCheckOrderDetailList(), checkOrderVORead.getCheckOrderDetailList());
        Assert.assertEquals(checkOrderSaveVO.getLocationName(), checkOrderVORead.getLocationName());
        Assert.assertEquals(checkOrderSaveVO.getStorehouseName(), checkOrderVORead.getStorehouseName());
        Assert.assertEquals(checkOrderSaveVO.getCategoryIdList(), checkOrderVORead.getCategoryIdList());
    }

    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testUpdate() throws Exception {
        CheckOrderSaveVO checkOrderSaveVO = MockUtil.fromFile("check_order_save.json", CheckOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        CheckOrderVO checkOrderVOSaved = Printer.print(response, CheckOrderVO.class);

        CheckOrderUpdateVO checkOrderUpdateVO = MockUtil.fromFile("check_order_update.json", CheckOrderUpdateVO.class);
        checkOrderUpdateVO.setId(checkOrderVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderUpdateVO, MockMvcResultMatchers.status().isOk());
        CheckOrderVO checkOrderVOUpdated = Printer.print(response, CheckOrderVO.class);
        Assert.assertEquals(checkOrderUpdateVO.getId(), checkOrderVOUpdated.getId());
        Assert.assertEquals(checkOrderUpdateVO.getOrderNo(), checkOrderVOUpdated.getOrderNo());
        Assert.assertEquals(checkOrderUpdateVO.getMerchantId(), checkOrderVOUpdated.getMerchantId());
        Assert.assertEquals(checkOrderUpdateVO.getCreateLocationId(), checkOrderVOUpdated.getCreateLocationId());
        Assert.assertEquals(checkOrderUpdateVO.getLocationId(), checkOrderVOUpdated.getLocationId());
        Assert.assertEquals(checkOrderUpdateVO.getStorehouseId(), checkOrderVOUpdated.getStorehouseId());
        Assert.assertEquals(checkOrderUpdateVO.getCheckedAt(), checkOrderVOUpdated.getCheckedAt());
        Assert.assertEquals(checkOrderUpdateVO.getStateCode(), checkOrderVOUpdated.getStateCode());
        Assert.assertEquals(checkOrderUpdateVO.getStateName(), checkOrderVOUpdated.getStateName());
        Assert.assertEquals(checkOrderUpdateVO.getMoney(), checkOrderVOUpdated.getMoney());
        Assert.assertEquals(checkOrderUpdateVO.getSource(), checkOrderVOUpdated.getSource());
        Assert.assertEquals(checkOrderUpdateVO.getSalesmanStaffName(), checkOrderVOUpdated.getSalesmanStaffName());
        Assert.assertEquals(checkOrderUpdateVO.getSalesmanStaffId(), checkOrderVOUpdated.getSalesmanStaffId());
        Assert.assertEquals(checkOrderUpdateVO.getBizday(), checkOrderVOUpdated.getBizday());
        Assert.assertEquals(checkOrderUpdateVO.getMemo(), checkOrderVOUpdated.getMemo());
        Assert.assertEquals(checkOrderUpdateVO.getCreatedAt(), checkOrderVOUpdated.getCreatedAt());
        Assert.assertEquals(checkOrderUpdateVO.getCreator(), checkOrderVOUpdated.getCreator());
        Assert.assertEquals(checkOrderUpdateVO.getUpdatedAt(), checkOrderVOUpdated.getUpdatedAt());
        Assert.assertEquals(checkOrderUpdateVO.getUpdator(), checkOrderVOUpdated.getUpdator());
        Assert.assertEquals(checkOrderUpdateVO.getAuditedAt(), checkOrderVOUpdated.getAuditedAt());
        Assert.assertEquals(checkOrderUpdateVO.getAuditor(), checkOrderVOUpdated.getAuditor());
        Assert.assertEquals(checkOrderUpdateVO.getCanceledAt(), checkOrderVOUpdated.getCanceledAt());
        Assert.assertEquals(checkOrderUpdateVO.getCancelor(), checkOrderVOUpdated.getCancelor());
        Assert.assertEquals(checkOrderUpdateVO.getRoundMoney(), checkOrderVOUpdated.getRoundMoney());
        Assert.assertEquals(checkOrderUpdateVO.getCheckOrderType(), checkOrderVOUpdated.getCheckOrderType());
        Assert.assertEquals(checkOrderUpdateVO.getFilterStopPurchaseIs(), checkOrderVOUpdated.getFilterStopPurchaseIs());
        Assert.assertEquals(checkOrderUpdateVO.getFilterDisuseIs(), checkOrderVOUpdated.getFilterDisuseIs());
        Assert.assertEquals(checkOrderUpdateVO.getFilterStopSellIs(), checkOrderVOUpdated.getFilterStopSellIs());
        Assert.assertEquals(checkOrderUpdateVO.getSnapshotIs(), checkOrderVOUpdated.getSnapshotIs());
        Assert.assertEquals(checkOrderUpdateVO.getSnapshotedAt(), checkOrderVOUpdated.getSnapshotedAt());
        Assert.assertEquals(checkOrderUpdateVO.getBlindCheckIs(), checkOrderVOUpdated.getBlindCheckIs());
        Assert.assertEquals(checkOrderUpdateVO.getCheckOrderDetailList(), checkOrderVOUpdated.getCheckOrderDetailList());
        Assert.assertEquals(checkOrderUpdateVO.getLocationName(), checkOrderVOUpdated.getLocationName());
        Assert.assertEquals(checkOrderUpdateVO.getStorehouseName(), checkOrderVOUpdated.getStorehouseName());
        Assert.assertEquals(checkOrderUpdateVO.getCategoryIdList(), checkOrderVOUpdated.getCategoryIdList());

        CheckOrderVO checkOrderVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderVOSaved.getId());
        Assert.assertEquals(checkOrderUpdateVO.getId(), checkOrderVORead.getId());
        Assert.assertEquals(checkOrderUpdateVO.getOrderNo(), checkOrderVORead.getOrderNo());
        Assert.assertEquals(checkOrderUpdateVO.getMerchantId(), checkOrderVORead.getMerchantId());
        Assert.assertEquals(checkOrderUpdateVO.getCreateLocationId(), checkOrderVORead.getCreateLocationId());
        Assert.assertEquals(checkOrderUpdateVO.getLocationId(), checkOrderVORead.getLocationId());
        Assert.assertEquals(checkOrderUpdateVO.getStorehouseId(), checkOrderVORead.getStorehouseId());
        Assert.assertEquals(checkOrderUpdateVO.getCheckedAt(), checkOrderVORead.getCheckedAt());
        Assert.assertEquals(checkOrderUpdateVO.getStateCode(), checkOrderVORead.getStateCode());
        Assert.assertEquals(checkOrderUpdateVO.getStateName(), checkOrderVORead.getStateName());
        Assert.assertEquals(checkOrderUpdateVO.getMoney(), checkOrderVORead.getMoney());
        Assert.assertEquals(checkOrderUpdateVO.getSource(), checkOrderVORead.getSource());
        Assert.assertEquals(checkOrderUpdateVO.getSalesmanStaffName(), checkOrderVORead.getSalesmanStaffName());
        Assert.assertEquals(checkOrderUpdateVO.getSalesmanStaffId(), checkOrderVORead.getSalesmanStaffId());
        Assert.assertEquals(checkOrderUpdateVO.getBizday(), checkOrderVORead.getBizday());
        Assert.assertEquals(checkOrderUpdateVO.getMemo(), checkOrderVORead.getMemo());
        Assert.assertEquals(checkOrderUpdateVO.getCreatedAt(), checkOrderVORead.getCreatedAt());
        Assert.assertEquals(checkOrderUpdateVO.getCreator(), checkOrderVORead.getCreator());
        Assert.assertEquals(checkOrderUpdateVO.getUpdatedAt(), checkOrderVORead.getUpdatedAt());
        Assert.assertEquals(checkOrderUpdateVO.getUpdator(), checkOrderVORead.getUpdator());
        Assert.assertEquals(checkOrderUpdateVO.getAuditedAt(), checkOrderVORead.getAuditedAt());
        Assert.assertEquals(checkOrderUpdateVO.getAuditor(), checkOrderVORead.getAuditor());
        Assert.assertEquals(checkOrderUpdateVO.getCanceledAt(), checkOrderVORead.getCanceledAt());
        Assert.assertEquals(checkOrderUpdateVO.getCancelor(), checkOrderVORead.getCancelor());
        Assert.assertEquals(checkOrderUpdateVO.getRoundMoney(), checkOrderVORead.getRoundMoney());
        Assert.assertEquals(checkOrderUpdateVO.getCheckOrderType(), checkOrderVORead.getCheckOrderType());
        Assert.assertEquals(checkOrderUpdateVO.getFilterStopPurchaseIs(), checkOrderVORead.getFilterStopPurchaseIs());
        Assert.assertEquals(checkOrderUpdateVO.getFilterDisuseIs(), checkOrderVORead.getFilterDisuseIs());
        Assert.assertEquals(checkOrderUpdateVO.getFilterStopSellIs(), checkOrderVORead.getFilterStopSellIs());
        Assert.assertEquals(checkOrderUpdateVO.getSnapshotIs(), checkOrderVORead.getSnapshotIs());
        Assert.assertEquals(checkOrderUpdateVO.getSnapshotedAt(), checkOrderVORead.getSnapshotedAt());
        Assert.assertEquals(checkOrderUpdateVO.getBlindCheckIs(), checkOrderVORead.getBlindCheckIs());
        Assert.assertEquals(checkOrderUpdateVO.getCheckOrderDetailList(), checkOrderVORead.getCheckOrderDetailList());
        Assert.assertEquals(checkOrderUpdateVO.getLocationName(), checkOrderVORead.getLocationName());
        Assert.assertEquals(checkOrderUpdateVO.getStorehouseName(), checkOrderVORead.getStorehouseName());
        Assert.assertEquals(checkOrderUpdateVO.getCategoryIdList(), checkOrderVORead.getCategoryIdList());
    }

    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testDelete() throws Exception {
        CheckOrderSaveVO checkOrderSaveVO = MockUtil.fromFile("check_order_save.json", CheckOrderSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderSaveVO, MockMvcResultMatchers.status().isCreated());
        CheckOrderVO checkOrderVOSaved = Printer.print(response, CheckOrderVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        CheckOrderVO checkOrder = read(ConstantsTest.HUAJY_MERCHANT_ID_1, checkOrderVOSaved.getId());
        Assert.assertEquals(null, checkOrder);
    }

    /**
    * 测试审核盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testAudit() throws Exception {
        CheckOrderAuditVO checkOrderAuditVO = new CheckOrderAuditVO();
        checkOrderAuditVO.setId();
        checkOrderAuditVO.setOrderNo();
        checkOrderAuditVO.setLocationId();
        checkOrderAuditVO.setStorehouseId();
        checkOrderAuditVO.setCheckedAt();
        checkOrderAuditVO.setMoney();
        checkOrderAuditVO.setSalesmanStaffName();
        checkOrderAuditVO.setSalesmanStaffId();
        checkOrderAuditVO.setMemo();
        checkOrderAuditVO.setRoundMoney();
        checkOrderAuditVO.setCheckOrderType();
        checkOrderAuditVO.setFilterStopPurchaseIs();
        checkOrderAuditVO.setFilterDisuseIs();
        checkOrderAuditVO.setFilterStopSellIs();
        checkOrderAuditVO.setCheckOrderDetailList();
        checkOrderAuditVO.setLocationName();
        checkOrderAuditVO.setStorehouseName();

        String url = BASE_URL + "/check_orders/audit.json";
        mockMvc.perform(MockMvcRequestBuilders.put(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderAuditVO))
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试作废盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testCancel() throws Exception {
        BigInteger id = ;

        String url = BASE_URL + "/check_orders/cancel/" + id + ".json";
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
    * 测试盘点单列表.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/check_orders.json";
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
                    .param("salesman_staff_id_list", "")
                    .param("query_name", "")
                    .param("current_location_id", "")
                    .param("offset", "")
                    .param("limit", "")
                    .param("sort_order", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<CheckOrderVO>>() {}.getType();
    List<CheckOrderVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试根据id审核盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testAuditById() throws Exception {
        BigInteger id = ;

        String url = BASE_URL + "/check_orders/audit/" + id + ".json";
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
    * 测试新增并审核盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testSaveAndAudit() throws Exception {
        CheckOrderSaveVO checkOrderSaveVO = new CheckOrderSaveVO();
        checkOrderSaveVO.setCreateLocationId();
        checkOrderSaveVO.setLocationId();
        checkOrderSaveVO.setStorehouseId();
        checkOrderSaveVO.setCheckedAt();
        checkOrderSaveVO.setMoney();
        checkOrderSaveVO.setSource();
        checkOrderSaveVO.setSalesmanStaffName();
        checkOrderSaveVO.setSalesmanStaffId();
        checkOrderSaveVO.setMemo();
        checkOrderSaveVO.setRoundMoney();
        checkOrderSaveVO.setCheckOrderType();
        checkOrderSaveVO.setFilterStopPurchaseIs();
        checkOrderSaveVO.setFilterDisuseIs();
        checkOrderSaveVO.setFilterStopSellIs();
        checkOrderSaveVO.setSnapshotIs();
        checkOrderSaveVO.setBlindCheckIs();
        checkOrderSaveVO.setCheckOrderDetailList();
        checkOrderSaveVO.setLocationName();
        checkOrderSaveVO.setStorehouseName();

        String url = BASE_URL + "/check_orders/save_and_audit.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderSaveVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试导出盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExport() throws Exception {
        CheckOrderExportVO checkOrderExportVO = new CheckOrderExportVO();
        checkOrderExportVO.setDateType();
        checkOrderExportVO.setDateMin();
        checkOrderExportVO.setDateMax();
        checkOrderExportVO.setLocationIdList();
        checkOrderExportVO.setLocationNameList();
        checkOrderExportVO.setStorehouseIdList();
        checkOrderExportVO.setStorehouseNameList();
        checkOrderExportVO.setStateCode();
        checkOrderExportVO.setOrderNo();
        checkOrderExportVO.setSalesmanStaffIdList();
        checkOrderExportVO.setSortOrder();
        checkOrderExportVO.setGridHeaderList();
        checkOrderExportVO.setStaffId();
        checkOrderExportVO.setLocationId();

        String url = BASE_URL + "/check_orders/export.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试批量打印盘点单.
    *
    * @throws Exception 异常
    */
    @Test
    public void testBatchPrint() throws Exception {
        CheckOrderPrintVO checkOrderPrintVO = new CheckOrderPrintVO();
        checkOrderPrintVO.setIdList();
        checkOrderPrintVO.setLocationId();
        checkOrderPrintVO.setSalesmanStaffId();

        String url = BASE_URL + "/check_orders/batch_print.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderPrintVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试导出盘点单明细.
    *
    * @throws Exception 异常
    */
    @Test
    public void testExportDetail() throws Exception {
        CheckOrderDetailExportVO checkOrderDetailExportVO = new CheckOrderDetailExportVO();
        checkOrderDetailExportVO.setDetailId();
        checkOrderDetailExportVO.setOrderNo();
        checkOrderDetailExportVO.setGridHeaderList();
        checkOrderDetailExportVO.setStaffId();
        checkOrderDetailExportVO.setLocationId();

        String url = BASE_URL + "/check_orders/export_detail.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderDetailExportVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试编辑库存快照.
    *
    * @throws Exception 异常
    */
    @Test
    public void testUpdateSnapshot() throws Exception {
        CheckOrderUpdateSnapshotVO checkOrderUpdateSnapshotVO = new CheckOrderUpdateSnapshotVO();
        checkOrderUpdateSnapshotVO.setId();
        checkOrderUpdateSnapshotVO.setSnapshotIs();

        String url = BASE_URL + "/check_orders/update_snapshot.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .content(gson.toJson(checkOrderUpdateSnapshotVO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andReturn().getResponse();
    }

    /**
    * 测试导入商品excel.
    *
    * @throws Exception 异常
    */
    @Test
    public void testImportExcel() throws Exception {
        String url = BASE_URL + "/check_orders/import_product.json";
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("location_id", "")
                    .param("storehouse_id", "")
                    .param("operator", "")
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
    private CheckOrderVO read(final BigInteger merchantId, final BigInteger id) throws Exception {
        String url = BASE_URL + "/check_orders/" + id + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, CheckOrderVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final CheckOrderSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/check_orders.json";
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
    private MockHttpServletResponse update(final BigInteger merchantId, final CheckOrderUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/check_orders.json";
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
        String url = BASE_URL + "/check_orders/" + id + ".json";
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
