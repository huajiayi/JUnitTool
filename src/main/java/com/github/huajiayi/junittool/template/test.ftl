package ${packageName};

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
* ${controller.name}单元测试.
*
* @author ${author}
*/
public class ${controller.name}Test extends BaseTest {

    private static final String BASE_URL = "${controller.baseUrl}";

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = JsonUtil.getGson(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    /**
    * 初始化.
    */
    @Before
    public void setup() {

    }
<#if controller.read??>
    /**
    * 读取测试.
    *
    * @throws Exception 异常信息
    */
    @Test
    public void testRead() throws Exception {
        ${controller.read.returnParam.type} ${controller.resourceName}VORead = read(${merchantId}<#list controller.read.pathVariableList as pathVariable>, </#list>);
    <#list controller.read.returnParam.paramList as param>
        Assert.assertEquals(, ${controller.resourceName}VORead.${param.getter}());
    </#list>
    }
</#if>

<#if controller.save??>
    /**
    * 保存测试.
    * 正常保存
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testSave() throws Exception {
        ${controller.save.requestBody.type} ${controller.resourceName}SaveVO = MockUtil.fromFile("${controller.jsonName}_save.json", ${controller.save.requestBody.type}.class);
        MockHttpServletResponse response = save(${merchantId}, ${controller.resourceName}SaveVO, MockMvcResultMatchers.status().isCreated());
        ${controller.save.returnParam.type} ${controller.resourceName}VOSaved = Printer.print(response, ${controller.save.returnParam.type}.class);

        ${controller.save.returnParam.type} ${controller.resourceName}VORead = read(${merchantId}, ${controller.resourceName}VOSaved.getId());
    <#list controller.save.returnParam.paramList as param>
        Assert.assertEquals(${controller.resourceName}SaveVO.${param.getter}(), ${controller.resourceName}VORead.${param.getter}());
    </#list>
    }
</#if>

<#if controller.update??>
    /**
    * 编辑测试.
    * 正常编辑
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testUpdate() throws Exception {
        ${controller.save.requestBody.type} ${controller.resourceName}SaveVO = MockUtil.fromFile("${controller.jsonName}_save.json", ${controller.save.requestBody.type}.class);
        MockHttpServletResponse response = save(${merchantId}, ${controller.resourceName}SaveVO, MockMvcResultMatchers.status().isCreated());
        ${controller.save.returnParam.type} ${controller.resourceName}VOSaved = Printer.print(response, ${controller.save.returnParam.type}.class);

        ${controller.update.requestBody.type} ${controller.resourceName}UpdateVO = MockUtil.fromFile("${controller.jsonName}_update.json", ${controller.update.requestBody.type}.class);
        ${controller.resourceName}UpdateVO.setId(${controller.resourceName}VOSaved.getId());
        response = update(${merchantId}, ${controller.resourceName}UpdateVO, MockMvcResultMatchers.status().isOk());
        ${controller.update.returnParam.type} ${controller.resourceName}VOUpdated = Printer.print(response, ${controller.update.returnParam.type}.class);
    <#list controller.update.returnParam.paramList as param>
        Assert.assertEquals(${controller.resourceName}UpdateVO.${param.getter}(), ${controller.resourceName}VOUpdated.${param.getter}());
    </#list>

        ${controller.save.returnParam.type} ${controller.resourceName}VORead = read(${merchantId}, ${controller.resourceName}VOSaved.getId());
    <#list controller.read.returnParam.paramList as param>
        Assert.assertEquals(${controller.resourceName}UpdateVO.${param.getter}(), ${controller.resourceName}VORead.${param.getter}());
    </#list>
    }
</#if>

<#if controller.delete??>
    /**
    * 删除测试.
    * 正常删除
    *
    * @throws Exception 异常信息
    */
    @Test
    @Transactional
    public void testDelete() throws Exception {
        ${controller.save.requestBody.type} ${controller.resourceName}SaveVO = MockUtil.fromFile("${controller.jsonName}_save.json", ${controller.save.requestBody.type}.class);
        MockHttpServletResponse response = save(${merchantId}, ${controller.resourceName}SaveVO, MockMvcResultMatchers.status().isCreated());
        ${controller.read.returnParam.type} ${controller.resourceName}VOSaved = Printer.print(response, ${controller.read.returnParam.type}.class);

        delete(${merchantId}, ${controller.resourceName}VOSaved.getId(), MockMvcResultMatchers.status().isOk());

        ${controller.read.returnParam.type} ${controller.resourceName} = read(${merchantId}, ${controller.resourceName}VOSaved.getId());
        Assert.assertEquals(null, ${controller.resourceName});
    }
</#if>

<#list controller.apis as api>
    /**
    * 测试${api.description}.
    *
    * @throws Exception 异常
    */
    @Test
    <#if api.method == 'put' || api.method == 'post'>
    @Transactional
    </#if>
    public void test${api.name?cap_first}() throws Exception {
    <#if api.pathVariableList?size gt 0>
        <#list api.pathVariableList as pathVariable>
        ${pathVariable.type} ${pathVariable.name} = ;
        </#list>

    </#if>
    <#if api.requestBody??>
        ${api.requestBody.type} ${api.requestBody.name} = new ${api.requestBody.type}();
        <#list api.requestBody.paramList as param>
        ${api.requestBody.name}.${param.setter}();
        </#list>

    </#if>
        String url = BASE_URL + "${api.url}";
        <#if api.requestBody?? && api.response.listIs?string('true', 'false') == 'true'>MockHttpServletResponse mockResponse = </#if>mockMvc.perform(MockMvcRequestBuilders.${api.method}(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(HeaderConstants.X_MARS_MERCHANT_ID, ${merchantId})
                    .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                    .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ${operator})
    <#if api.requestParamList?size gt 0>
        <#list api.requestParamList as requestParam>
                    .param("${requestParam.jsonName}", "")<#if !requestParam_has_next>)</#if>
        </#list>
    </#if>
    <#if api.requestBody??>
                    .content(gson.toJson(${api.requestBody.name})))
    </#if>
    <#if api.method == 'post'>
            .andExpect(MockMvcResultMatchers.status().isCreated())
    <#else>
            .andExpect(MockMvcResultMatchers.status().isOk())
    </#if>
            .andReturn().getResponse();
    <#if api.response?? && api.response.listIs?string('true', 'false') == 'true'>
    Type type = new TypeToken${'<'?string}${api.response.type}>() {}.getType();
    ${api.response.type} print = Printer.print(mockResponse, type);
        Assert.assertEquals(, print.size());
    </#if>
    }

</#list>

<#if controller.read??>
    /**
    * 读取.
    *
    * @param merchantId 商户id
    <#list controller.read.pathVariableList as pathVariable>
    * @param ${pathVariable.name} ${pathVariable.description}
    </#list>
    * @return 返回对象
    */
    private ${controller.read.returnParam.type} read(final BigInteger merchantId<#list controller.read.pathVariableList as pathVariable>,final ${pathVariable.type} ${pathVariable.name}</#list>) throws Exception {
        String url = BASE_URL + "${controller.read.url}";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ${operator}))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        return Printer.print(mockResponse, ${controller.read.returnParam.type}.class);
    }
</#if>

<#if controller.save??>
    /**
     * 保存.
     *
     * @param merchantId 商户id
     * @param saveVO     保存VO
     * @param resultMatcher 返回状态
     * @return 响应
     */
    private MockHttpServletResponse save(final BigInteger merchantId, final ${controller.save.requestBody.type} saveVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "${controller.save.url}";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ${operator})
                        .content(gson.toJson(saveVO)))
                .andExpect(resultMatcher)
                .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse;
    }
</#if>

<#if controller.update??>
    /**
    * 更新.
    *
    * @param merchantId 商户id
    * @param updateVO   更新VO
    * @param resultMatcher 返回状态
    * @return 响应
    */
    private MockHttpServletResponse update(final BigInteger merchantId, final ${controller.update.requestBody.type} updateVO, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "${controller.update.url}";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
                        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
                        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ${operator})
                        .content(gson.toJson(updateVO)))
                .andExpect(resultMatcher)
                .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse;
    }
</#if>

<#if controller.delete??>
    /**
    * 删除.
    *
    * @param merchantId 商户id
    <#list controller.delete.pathVariableList as pathVariable>
    * @param ${pathVariable.name} ${pathVariable.description}
    </#list>
    * @param resultMatcher 返回状态
    * @return 响应
    */
    private MockHttpServletResponse delete(final BigInteger merchantId, final BigInteger id, final ResultMatcher resultMatcher) throws Exception {
        String url = BASE_URL + "${controller.delete.url}";
        MockHttpServletResponse mockResponse = mockMvc.perform(MockMvcRequestBuilders.delete(url)
        .contentType(MediaType.APPLICATION_JSON)
        .header(HeaderConstants.X_MARS_MERCHANT_ID, merchantId)
        .header(HeaderConstants.X_MARS_ACCESS_TOKEN, ConstantsTest.X_MARS_ACCESS_TOKEN)
        .header(HeaderConstants.X_MARS_MERCHANT_OPERATOR, ${operator}))
        .andExpect(resultMatcher)
        .andReturn().getResponse();
        mockResponse.setCharacterEncoding("UTF-8");

        return mockResponse
    }
</#if>
}
