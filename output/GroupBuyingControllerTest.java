package com.nhsoft.mars.promotion.adapter.web;

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
* GroupBuyingController单元测试.
*
* @author nhsoft.huajy
*/
@Transactional
public class GroupBuyingControllerTest extends BaseTest {

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
        GroupBuyingVO groupBuyingVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, );
        Assert.assertEquals(, groupBuyingVORead.getId());
        Assert.assertEquals(, groupBuyingVORead.getMerchantId());
        Assert.assertEquals(, groupBuyingVORead.getTitle());
        Assert.assertEquals(, groupBuyingVORead.getActivityDateType());
        Assert.assertEquals(, groupBuyingVORead.getProcessAtMin());
        Assert.assertEquals(, groupBuyingVORead.getProcessAtMax());
        Assert.assertEquals(, groupBuyingVORead.getCycleRepeatStartDate());
        Assert.assertEquals(, groupBuyingVORead.getCycleRepeatEndDate());
        Assert.assertEquals(, groupBuyingVORead.getCycleRepeatStartTime());
        Assert.assertEquals(, groupBuyingVORead.getCycleRepeatEndTime());
        Assert.assertEquals(, groupBuyingVORead.getTicketSuperpositionIs());
        Assert.assertEquals(, groupBuyingVORead.getGroupSuccessDay());
        Assert.assertEquals(, groupBuyingVORead.getGroupSuccessHour());
        Assert.assertEquals(, groupBuyingVORead.getGroupSuccessMinute());
        Assert.assertEquals(, groupBuyingVORead.getGroupSuccessCustomerCount());
        Assert.assertEquals(, groupBuyingVORead.getShareTitle());
        Assert.assertEquals(, groupBuyingVORead.getShareImageUrl());
        Assert.assertEquals(, groupBuyingVORead.getGatherTogetherEnable());
        Assert.assertEquals(, groupBuyingVORead.getVirtualSuccessEnable());
        Assert.assertEquals(, groupBuyingVORead.getLocationScope());
        Assert.assertEquals(, groupBuyingVORead.getFulfillmentTypeList());
        Assert.assertEquals(, groupBuyingVORead.getInventoryShowEnable());
        Assert.assertEquals(, groupBuyingVORead.getSaleVolumnsShowEnable());
        Assert.assertEquals(, groupBuyingVORead.getVirtualSaleVolumns());
        Assert.assertEquals(, groupBuyingVORead.getOverSaleEnable());
        Assert.assertEquals(, groupBuyingVORead.getCreatedAt());
        Assert.assertEquals(, groupBuyingVORead.getCreator());
        Assert.assertEquals(, groupBuyingVORead.getUpdatedAt());
        Assert.assertEquals(, groupBuyingVORead.getUpdater());
        Assert.assertEquals(, groupBuyingVORead.getEndIs());
        Assert.assertEquals(, groupBuyingVORead.getGroupBuyingLocationList());
        Assert.assertEquals(, groupBuyingVORead.getGroupBuyingVariantList());
        Assert.assertEquals(, groupBuyingVORead.getActivityImgUrl());
        Assert.assertEquals(, groupBuyingVORead.getNewCustomerJoinIs());
        Assert.assertEquals(, groupBuyingVORead.getBuyLimitType());
        Assert.assertEquals(, groupBuyingVORead.getMaxBuyQty());
        Assert.assertEquals(, groupBuyingVORead.getMaxBuyTimes());
        Assert.assertEquals(, groupBuyingVORead.getActivityType());
        Assert.assertEquals(, groupBuyingVORead.getGroupBuyingCustomerStepList());
        Assert.assertEquals(, groupBuyingVORead.getCreateLocationId());
        Assert.assertEquals(, groupBuyingVORead.getCreateLocationZoneId());
        Assert.assertEquals(, groupBuyingVORead.getStatus());
        Assert.assertEquals(, groupBuyingVORead.getFullGroupCount());
        Assert.assertEquals(, groupBuyingVORead.getStartGroupCount());
        Assert.assertEquals(, groupBuyingVORead.getTotalGroupCustomerCount());
        Assert.assertEquals(, groupBuyingVORead.getSuccessGroupOrderCount());
    }

    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testSave() throws Exception {
        GroupBuyingSaveVO groupBuyingSaveVO = MockUtil.fromFile("group_buying_save.json", GroupBuyingSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingSaveVO, MockMvcResultMatchers.status().isCreated());
        GroupBuyingVO groupBuyingVOSaved = Printer.print(response, GroupBuyingVO.class);

        GroupBuyingVO groupBuyingVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingVOSaved.getId());
        Assert.assertEquals(groupBuyingSaveVO.getId(), groupBuyingVORead.getId());
        Assert.assertEquals(groupBuyingSaveVO.getMerchantId(), groupBuyingVORead.getMerchantId());
        Assert.assertEquals(groupBuyingSaveVO.getTitle(), groupBuyingVORead.getTitle());
        Assert.assertEquals(groupBuyingSaveVO.getActivityDateType(), groupBuyingVORead.getActivityDateType());
        Assert.assertEquals(groupBuyingSaveVO.getProcessAtMin(), groupBuyingVORead.getProcessAtMin());
        Assert.assertEquals(groupBuyingSaveVO.getProcessAtMax(), groupBuyingVORead.getProcessAtMax());
        Assert.assertEquals(groupBuyingSaveVO.getCycleRepeatStartDate(), groupBuyingVORead.getCycleRepeatStartDate());
        Assert.assertEquals(groupBuyingSaveVO.getCycleRepeatEndDate(), groupBuyingVORead.getCycleRepeatEndDate());
        Assert.assertEquals(groupBuyingSaveVO.getCycleRepeatStartTime(), groupBuyingVORead.getCycleRepeatStartTime());
        Assert.assertEquals(groupBuyingSaveVO.getCycleRepeatEndTime(), groupBuyingVORead.getCycleRepeatEndTime());
        Assert.assertEquals(groupBuyingSaveVO.getTicketSuperpositionIs(), groupBuyingVORead.getTicketSuperpositionIs());
        Assert.assertEquals(groupBuyingSaveVO.getGroupSuccessDay(), groupBuyingVORead.getGroupSuccessDay());
        Assert.assertEquals(groupBuyingSaveVO.getGroupSuccessHour(), groupBuyingVORead.getGroupSuccessHour());
        Assert.assertEquals(groupBuyingSaveVO.getGroupSuccessMinute(), groupBuyingVORead.getGroupSuccessMinute());
        Assert.assertEquals(groupBuyingSaveVO.getGroupSuccessCustomerCount(), groupBuyingVORead.getGroupSuccessCustomerCount());
        Assert.assertEquals(groupBuyingSaveVO.getShareTitle(), groupBuyingVORead.getShareTitle());
        Assert.assertEquals(groupBuyingSaveVO.getShareImageUrl(), groupBuyingVORead.getShareImageUrl());
        Assert.assertEquals(groupBuyingSaveVO.getGatherTogetherEnable(), groupBuyingVORead.getGatherTogetherEnable());
        Assert.assertEquals(groupBuyingSaveVO.getVirtualSuccessEnable(), groupBuyingVORead.getVirtualSuccessEnable());
        Assert.assertEquals(groupBuyingSaveVO.getLocationScope(), groupBuyingVORead.getLocationScope());
        Assert.assertEquals(groupBuyingSaveVO.getFulfillmentTypeList(), groupBuyingVORead.getFulfillmentTypeList());
        Assert.assertEquals(groupBuyingSaveVO.getInventoryShowEnable(), groupBuyingVORead.getInventoryShowEnable());
        Assert.assertEquals(groupBuyingSaveVO.getSaleVolumnsShowEnable(), groupBuyingVORead.getSaleVolumnsShowEnable());
        Assert.assertEquals(groupBuyingSaveVO.getVirtualSaleVolumns(), groupBuyingVORead.getVirtualSaleVolumns());
        Assert.assertEquals(groupBuyingSaveVO.getOverSaleEnable(), groupBuyingVORead.getOverSaleEnable());
        Assert.assertEquals(groupBuyingSaveVO.getCreatedAt(), groupBuyingVORead.getCreatedAt());
        Assert.assertEquals(groupBuyingSaveVO.getCreator(), groupBuyingVORead.getCreator());
        Assert.assertEquals(groupBuyingSaveVO.getUpdatedAt(), groupBuyingVORead.getUpdatedAt());
        Assert.assertEquals(groupBuyingSaveVO.getUpdater(), groupBuyingVORead.getUpdater());
        Assert.assertEquals(groupBuyingSaveVO.getEndIs(), groupBuyingVORead.getEndIs());
        Assert.assertEquals(groupBuyingSaveVO.getGroupBuyingLocationList(), groupBuyingVORead.getGroupBuyingLocationList());
        Assert.assertEquals(groupBuyingSaveVO.getGroupBuyingVariantList(), groupBuyingVORead.getGroupBuyingVariantList());
        Assert.assertEquals(groupBuyingSaveVO.getActivityImgUrl(), groupBuyingVORead.getActivityImgUrl());
        Assert.assertEquals(groupBuyingSaveVO.getNewCustomerJoinIs(), groupBuyingVORead.getNewCustomerJoinIs());
        Assert.assertEquals(groupBuyingSaveVO.getBuyLimitType(), groupBuyingVORead.getBuyLimitType());
        Assert.assertEquals(groupBuyingSaveVO.getMaxBuyQty(), groupBuyingVORead.getMaxBuyQty());
        Assert.assertEquals(groupBuyingSaveVO.getMaxBuyTimes(), groupBuyingVORead.getMaxBuyTimes());
        Assert.assertEquals(groupBuyingSaveVO.getActivityType(), groupBuyingVORead.getActivityType());
        Assert.assertEquals(groupBuyingSaveVO.getGroupBuyingCustomerStepList(), groupBuyingVORead.getGroupBuyingCustomerStepList());
        Assert.assertEquals(groupBuyingSaveVO.getCreateLocationId(), groupBuyingVORead.getCreateLocationId());
        Assert.assertEquals(groupBuyingSaveVO.getCreateLocationZoneId(), groupBuyingVORead.getCreateLocationZoneId());
        Assert.assertEquals(groupBuyingSaveVO.getStatus(), groupBuyingVORead.getStatus());
        Assert.assertEquals(groupBuyingSaveVO.getFullGroupCount(), groupBuyingVORead.getFullGroupCount());
        Assert.assertEquals(groupBuyingSaveVO.getStartGroupCount(), groupBuyingVORead.getStartGroupCount());
        Assert.assertEquals(groupBuyingSaveVO.getTotalGroupCustomerCount(), groupBuyingVORead.getTotalGroupCustomerCount());
        Assert.assertEquals(groupBuyingSaveVO.getSuccessGroupOrderCount(), groupBuyingVORead.getSuccessGroupOrderCount());
    }

    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testUpdate() throws Exception {
        GroupBuyingSaveVO groupBuyingSaveVO = MockUtil.fromFile("group_buying_save.json", GroupBuyingSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingSaveVO, MockMvcResultMatchers.status().isCreated());
        GroupBuyingVO groupBuyingVOSaved = Printer.print(response, GroupBuyingVO.class);

        GroupBuyingUpdateVO groupBuyingUpdateVO = MockUtil.fromFile("group_buying_update.json", GroupBuyingUpdateVO.class);
        groupBuyingUpdateVO.setId(groupBuyingVOSaved.getId());
        response = update(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingUpdateVO, MockMvcResultMatchers.status().isOk());
        GroupBuyingVO groupBuyingVOUpdated = Printer.print(response, GroupBuyingVO.class);
        Assert.assertEquals(groupBuyingUpdateVO.getId(), groupBuyingVOUpdated.getId());
        Assert.assertEquals(groupBuyingUpdateVO.getMerchantId(), groupBuyingVOUpdated.getMerchantId());
        Assert.assertEquals(groupBuyingUpdateVO.getTitle(), groupBuyingVOUpdated.getTitle());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityDateType(), groupBuyingVOUpdated.getActivityDateType());
        Assert.assertEquals(groupBuyingUpdateVO.getProcessAtMin(), groupBuyingVOUpdated.getProcessAtMin());
        Assert.assertEquals(groupBuyingUpdateVO.getProcessAtMax(), groupBuyingVOUpdated.getProcessAtMax());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatStartDate(), groupBuyingVOUpdated.getCycleRepeatStartDate());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatEndDate(), groupBuyingVOUpdated.getCycleRepeatEndDate());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatStartTime(), groupBuyingVOUpdated.getCycleRepeatStartTime());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatEndTime(), groupBuyingVOUpdated.getCycleRepeatEndTime());
        Assert.assertEquals(groupBuyingUpdateVO.getTicketSuperpositionIs(), groupBuyingVOUpdated.getTicketSuperpositionIs());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessDay(), groupBuyingVOUpdated.getGroupSuccessDay());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessHour(), groupBuyingVOUpdated.getGroupSuccessHour());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessMinute(), groupBuyingVOUpdated.getGroupSuccessMinute());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessCustomerCount(), groupBuyingVOUpdated.getGroupSuccessCustomerCount());
        Assert.assertEquals(groupBuyingUpdateVO.getShareTitle(), groupBuyingVOUpdated.getShareTitle());
        Assert.assertEquals(groupBuyingUpdateVO.getShareImageUrl(), groupBuyingVOUpdated.getShareImageUrl());
        Assert.assertEquals(groupBuyingUpdateVO.getGatherTogetherEnable(), groupBuyingVOUpdated.getGatherTogetherEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getVirtualSuccessEnable(), groupBuyingVOUpdated.getVirtualSuccessEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getLocationScope(), groupBuyingVOUpdated.getLocationScope());
        Assert.assertEquals(groupBuyingUpdateVO.getFulfillmentTypeList(), groupBuyingVOUpdated.getFulfillmentTypeList());
        Assert.assertEquals(groupBuyingUpdateVO.getInventoryShowEnable(), groupBuyingVOUpdated.getInventoryShowEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getSaleVolumnsShowEnable(), groupBuyingVOUpdated.getSaleVolumnsShowEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getVirtualSaleVolumns(), groupBuyingVOUpdated.getVirtualSaleVolumns());
        Assert.assertEquals(groupBuyingUpdateVO.getOverSaleEnable(), groupBuyingVOUpdated.getOverSaleEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getCreatedAt(), groupBuyingVOUpdated.getCreatedAt());
        Assert.assertEquals(groupBuyingUpdateVO.getCreator(), groupBuyingVOUpdated.getCreator());
        Assert.assertEquals(groupBuyingUpdateVO.getUpdatedAt(), groupBuyingVOUpdated.getUpdatedAt());
        Assert.assertEquals(groupBuyingUpdateVO.getUpdater(), groupBuyingVOUpdated.getUpdater());
        Assert.assertEquals(groupBuyingUpdateVO.getEndIs(), groupBuyingVOUpdated.getEndIs());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingLocationList(), groupBuyingVOUpdated.getGroupBuyingLocationList());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingVariantList(), groupBuyingVOUpdated.getGroupBuyingVariantList());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityImgUrl(), groupBuyingVOUpdated.getActivityImgUrl());
        Assert.assertEquals(groupBuyingUpdateVO.getNewCustomerJoinIs(), groupBuyingVOUpdated.getNewCustomerJoinIs());
        Assert.assertEquals(groupBuyingUpdateVO.getBuyLimitType(), groupBuyingVOUpdated.getBuyLimitType());
        Assert.assertEquals(groupBuyingUpdateVO.getMaxBuyQty(), groupBuyingVOUpdated.getMaxBuyQty());
        Assert.assertEquals(groupBuyingUpdateVO.getMaxBuyTimes(), groupBuyingVOUpdated.getMaxBuyTimes());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityType(), groupBuyingVOUpdated.getActivityType());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingCustomerStepList(), groupBuyingVOUpdated.getGroupBuyingCustomerStepList());
        Assert.assertEquals(groupBuyingUpdateVO.getCreateLocationId(), groupBuyingVOUpdated.getCreateLocationId());
        Assert.assertEquals(groupBuyingUpdateVO.getCreateLocationZoneId(), groupBuyingVOUpdated.getCreateLocationZoneId());
        Assert.assertEquals(groupBuyingUpdateVO.getStatus(), groupBuyingVOUpdated.getStatus());
        Assert.assertEquals(groupBuyingUpdateVO.getFullGroupCount(), groupBuyingVOUpdated.getFullGroupCount());
        Assert.assertEquals(groupBuyingUpdateVO.getStartGroupCount(), groupBuyingVOUpdated.getStartGroupCount());
        Assert.assertEquals(groupBuyingUpdateVO.getTotalGroupCustomerCount(), groupBuyingVOUpdated.getTotalGroupCustomerCount());
        Assert.assertEquals(groupBuyingUpdateVO.getSuccessGroupOrderCount(), groupBuyingVOUpdated.getSuccessGroupOrderCount());

        GroupBuyingVO groupBuyingVORead = read(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingVOSaved.getId());
        Assert.assertEquals(groupBuyingUpdateVO.getId(), groupBuyingVORead.getId());
        Assert.assertEquals(groupBuyingUpdateVO.getMerchantId(), groupBuyingVORead.getMerchantId());
        Assert.assertEquals(groupBuyingUpdateVO.getTitle(), groupBuyingVORead.getTitle());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityDateType(), groupBuyingVORead.getActivityDateType());
        Assert.assertEquals(groupBuyingUpdateVO.getProcessAtMin(), groupBuyingVORead.getProcessAtMin());
        Assert.assertEquals(groupBuyingUpdateVO.getProcessAtMax(), groupBuyingVORead.getProcessAtMax());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatStartDate(), groupBuyingVORead.getCycleRepeatStartDate());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatEndDate(), groupBuyingVORead.getCycleRepeatEndDate());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatStartTime(), groupBuyingVORead.getCycleRepeatStartTime());
        Assert.assertEquals(groupBuyingUpdateVO.getCycleRepeatEndTime(), groupBuyingVORead.getCycleRepeatEndTime());
        Assert.assertEquals(groupBuyingUpdateVO.getTicketSuperpositionIs(), groupBuyingVORead.getTicketSuperpositionIs());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessDay(), groupBuyingVORead.getGroupSuccessDay());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessHour(), groupBuyingVORead.getGroupSuccessHour());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessMinute(), groupBuyingVORead.getGroupSuccessMinute());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupSuccessCustomerCount(), groupBuyingVORead.getGroupSuccessCustomerCount());
        Assert.assertEquals(groupBuyingUpdateVO.getShareTitle(), groupBuyingVORead.getShareTitle());
        Assert.assertEquals(groupBuyingUpdateVO.getShareImageUrl(), groupBuyingVORead.getShareImageUrl());
        Assert.assertEquals(groupBuyingUpdateVO.getGatherTogetherEnable(), groupBuyingVORead.getGatherTogetherEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getVirtualSuccessEnable(), groupBuyingVORead.getVirtualSuccessEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getLocationScope(), groupBuyingVORead.getLocationScope());
        Assert.assertEquals(groupBuyingUpdateVO.getFulfillmentTypeList(), groupBuyingVORead.getFulfillmentTypeList());
        Assert.assertEquals(groupBuyingUpdateVO.getInventoryShowEnable(), groupBuyingVORead.getInventoryShowEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getSaleVolumnsShowEnable(), groupBuyingVORead.getSaleVolumnsShowEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getVirtualSaleVolumns(), groupBuyingVORead.getVirtualSaleVolumns());
        Assert.assertEquals(groupBuyingUpdateVO.getOverSaleEnable(), groupBuyingVORead.getOverSaleEnable());
        Assert.assertEquals(groupBuyingUpdateVO.getCreatedAt(), groupBuyingVORead.getCreatedAt());
        Assert.assertEquals(groupBuyingUpdateVO.getCreator(), groupBuyingVORead.getCreator());
        Assert.assertEquals(groupBuyingUpdateVO.getUpdatedAt(), groupBuyingVORead.getUpdatedAt());
        Assert.assertEquals(groupBuyingUpdateVO.getUpdater(), groupBuyingVORead.getUpdater());
        Assert.assertEquals(groupBuyingUpdateVO.getEndIs(), groupBuyingVORead.getEndIs());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingLocationList(), groupBuyingVORead.getGroupBuyingLocationList());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingVariantList(), groupBuyingVORead.getGroupBuyingVariantList());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityImgUrl(), groupBuyingVORead.getActivityImgUrl());
        Assert.assertEquals(groupBuyingUpdateVO.getNewCustomerJoinIs(), groupBuyingVORead.getNewCustomerJoinIs());
        Assert.assertEquals(groupBuyingUpdateVO.getBuyLimitType(), groupBuyingVORead.getBuyLimitType());
        Assert.assertEquals(groupBuyingUpdateVO.getMaxBuyQty(), groupBuyingVORead.getMaxBuyQty());
        Assert.assertEquals(groupBuyingUpdateVO.getMaxBuyTimes(), groupBuyingVORead.getMaxBuyTimes());
        Assert.assertEquals(groupBuyingUpdateVO.getActivityType(), groupBuyingVORead.getActivityType());
        Assert.assertEquals(groupBuyingUpdateVO.getGroupBuyingCustomerStepList(), groupBuyingVORead.getGroupBuyingCustomerStepList());
        Assert.assertEquals(groupBuyingUpdateVO.getCreateLocationId(), groupBuyingVORead.getCreateLocationId());
        Assert.assertEquals(groupBuyingUpdateVO.getCreateLocationZoneId(), groupBuyingVORead.getCreateLocationZoneId());
        Assert.assertEquals(groupBuyingUpdateVO.getStatus(), groupBuyingVORead.getStatus());
        Assert.assertEquals(groupBuyingUpdateVO.getFullGroupCount(), groupBuyingVORead.getFullGroupCount());
        Assert.assertEquals(groupBuyingUpdateVO.getStartGroupCount(), groupBuyingVORead.getStartGroupCount());
        Assert.assertEquals(groupBuyingUpdateVO.getTotalGroupCustomerCount(), groupBuyingVORead.getTotalGroupCustomerCount());
        Assert.assertEquals(groupBuyingUpdateVO.getSuccessGroupOrderCount(), groupBuyingVORead.getSuccessGroupOrderCount());
    }

    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testDelete() throws Exception {
        GroupBuyingSaveVO groupBuyingSaveVO = MockUtil.fromFile("group_buying_save.json", GroupBuyingSaveVO.class);
        MockHttpServletResponse response = save(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingSaveVO, MockMvcResultMatchers.status().isCreated());
        GroupBuyingVO groupBuyingVOSaved = Printer.print(response, GroupBuyingVO.class);

        delete(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingVOSaved.getId(), MockMvcResultMatchers.status().isOk());

        GroupBuyingVO groupBuying = read(ConstantsTest.HUAJY_MERCHANT_ID_1, groupBuyingVOSaved.getId());
        Assert.assertEquals(null, groupBuying);
    }

    /**
    * 测试结束拼团.
    *
    * @throws Exception 异常
    */
    @Test
    public void testDisable() throws Exception {
        BigInteger groupBuyingId = ;

        String url = BASE_URL + "/group_buying/" + groupBuyingId + "/disable.json";
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
    * 测试拼团详情.
    *
    * @throws Exception 异常
    */
    @Test
    public void testDetail() throws Exception {
        BigInteger groupBuyingId = ;

        String url = BASE_URL + "/group_buying/" + groupBuyingId + "/detail.json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("offset", "")
                    .param("limit", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试查询拼团.
    *
    * @throws Exception 异常
    */
    @Test
    public void testList() throws Exception {
        String url = BASE_URL + "/group_buying.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("current_location_id", "")
                    .param("current_location_zone_id", "")
                    .param("status_list", "")
                    .param("date_at_min", "")
                    .param("date_at_max", "")
                    .param("query_name", "")
                    .param("location_id_list", "")
                    .param("activity_type_list", "")
                    .param("offset", "")
                    .param("limit", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<GroupBuyingVO>>() {}.getType();
    List<GroupBuyingVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }

    /**
    * 测试小程序读取拼团.
    *
    * @throws Exception 异常
    */
    @Test
    public void testReadMpDetail() throws Exception {
        BigInteger groupBuyingId = ;

        String url = BASE_URL + "/group_buying/mp/" + groupBuyingId + ".json";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("customer_id", "")
                    .param("location_id", "")
                    .param("fulfillment_type", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    }

    /**
    * 测试小程序拼团列表.
    *
    * @throws Exception 异常
    */
    @Test
    public void testMpList() throws Exception {
        String url = BASE_URL + "/group_buying/mp.json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ConstantsTest.HUAJY_MERCHANT_ID_1)
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY)
                    .param("location_id", "")
                    .param("status", "")
                    .param("fulfillment_type", "")
                    .param("offset", "")
                    .param("limit", "")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().getResponse();
    Type type = new TypeToken<List<GroupBuyingMpDetailVO>>() {}.getType();
    List<GroupBuyingMpDetailVO> print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    }


    /**
    * 读取.
    *
    * @param merchantId 商户id
    * @param groupBuyingId groupBuyingId
    * @return 返回对象
    */
    private GroupBuyingVO read(final BigInteger merchantId, final BigInteger groupBuyingId) throws Exception {
        String url = BASE_URL + "/group_buying/" + groupBuyingId + ".json";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ConstantsTest.OPERATOR_HUAJY))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, GroupBuyingVO.class);
    }

    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final GroupBuyingSaveVO saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/group_buying.json";
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
    private MockHttpServletResponse update(final BigInteger merchantId, final GroupBuyingUpdateVO updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/group_buying/" + groupBuyingId + ".json";
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
    * @param groupBuyingId groupBuyingId
    * @param resultMatcher 返回状态
    * @return 响应
    */
    private MockHttpServletResponse delete(final BigInteger merchantId, final BigInteger id, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "/group_buying/" + groupBuyingId + ".json";
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
