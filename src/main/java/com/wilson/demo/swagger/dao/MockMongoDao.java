package com.wilson.demo.swagger.dao;

import com.alibaba.fastjson.JSONObject;
import com.wilson.demo.swagger.model.SwaggerBody;
import com.wilson.demo.swagger.model.SwaggerModel;
import com.wilson.demo.swagger.model.SwaggerPath;
import com.wilson.demo.swagger.model.SwaggerTag;
import io.swagger.models.*;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.properties.ObjectProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.StringProperty;
import io.swagger.util.Json;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Dao：模拟NoSQL数据库CRUD
 * <li>目标：提供Swagger各对象模拟查询操作</li>
 * <li>使用方式：装载至Service层调用</li>
 * <li>现有bug：不能直接通过FastJSON，会产生大量无用属性，需要使用Json.pretty()方法支持</li>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public class MockMongoDao {

    private static Map<String, Response> responses = new HashMap<>();

    static {
        responses.put("200", new Response().description("Success"));
        responses.put("400", new Response().description("Bad request"));
        responses.put("401", new Response().description("Unauthorized"));
        responses.put("403", new Response().description("Forbidden"));
        responses.put("404", new Response().description("Not found"));
        responses.put("500", new Response().description("Internal Server Error"));
    }

    /**
     * 模拟查询Swagger主体
     * @return Swagger主体
     */
    public SwaggerBody querySwagger() {
        Swagger swagger = new Swagger();
        Contact contact = new Contact();
        contact.setName("Wilson Support");
        contact.setEmail("support@wilson.com");
        contact.setUrl("http://www.baidu.com");
        Info info = new Info();
        info.setContact(contact);
        info.setTitle("我的Swagger REST API");
        info.setDescription("代码生成json");
        info.setVersion("0.0.1");
        swagger.setInfo(info);
        swagger.setSchemes(Arrays.asList(Scheme.HTTP));
        swagger.setHost("127.0.0.1:8080");
        swagger.setBasePath("/v1");

        SwaggerBody swaggerBody = new SwaggerBody();
        swaggerBody.setId("1");
        swaggerBody.setJson(JSONObject.parseObject(Json.pretty(swagger)));

        return swaggerBody;
    }

    /**
     * 模拟查询标签
     * @return Swagger标签列表
     */
    public List<SwaggerTag> queryTags() {
        List<SwaggerTag> list = new ArrayList<>();

        SwaggerTag swaggerTag1 = new SwaggerTag();
        swaggerTag1.setId(UUID.randomUUID().toString());
        swaggerTag1.setSwaggerId("1");
        swaggerTag1.setJson(new Tag().name("tag1").description("控制器1"));
        list.add(swaggerTag1);

        SwaggerTag swaggerTag2 = new SwaggerTag();
        swaggerTag2.setId(UUID.randomUUID().toString());
        swaggerTag2.setSwaggerId("1");
        swaggerTag2.setJson(new Tag().name("tag2").description("控制器2"));
        list.add(swaggerTag2);

        return list;
    }

    /**
     * 模拟查询Models
     * @return model列表
     */
    public List<SwaggerModel> queryModels() {
        List<SwaggerModel> list = new ArrayList<>();

        SwaggerModel model1 = new SwaggerModel();
        model1.setId(UUID.randomUUID().toString());
        model1.setSwaggerId("1");

        Map<String, Model> models = new HashMap<String, Model>();
        Model model = new ModelImpl();
        Map<String, Property> propertyMap = new HashMap<>();
        propertyMap.put("code", new StringProperty()._default("000000"));
        propertyMap.put("msg", new StringProperty()._default("成功"));
        propertyMap.put("data", new ObjectProperty());
        model.setProperties(propertyMap);
        models.put("resultDto", model);
        model1.setJson(JSONObject.parseObject(Json.pretty(models)));
        list.add(model1);

        return list;
    }

    /**
     * 模拟查询API
     * @return api列表
     */
    public List<SwaggerPath> queryPaths() {
        List<SwaggerPath> list = new ArrayList<>();

        SwaggerPath path = new SwaggerPath();
        path.setId(UUID.randomUUID().toString());
        path.setSwaggerId("1");

        Operation get = new Operation();
        get.setTags(Arrays.asList("tag1"));
        get.setSummary("查询用户");
        get.setDescription("。。。。。");
        get.setConsumes(Arrays.asList("application/json"));
        get.setProduces(Arrays.asList("application/json"));
        get.setResponses(responses);

        QueryParameter username = new QueryParameter();
        username.setType("string");
        username.setName("userName");
        username.setRequired(true);
        username.setDescription("用户名称");
        get.setParameters(Arrays.asList(username));

        Map<String, Path> paths = new HashMap<>();
        paths.put("/users", new Path().get(get));
        path.setJson(JSONObject.parseObject(Json.pretty(paths)));

        list.add(path);
        return list;
    }
}
