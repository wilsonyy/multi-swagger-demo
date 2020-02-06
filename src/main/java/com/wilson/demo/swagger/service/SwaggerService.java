package com.wilson.demo.swagger.service;

import com.alibaba.fastjson.JSONObject;
import com.wilson.demo.swagger.dao.MockMongoDao;
import com.wilson.demo.swagger.model.SwaggerModel;
import com.wilson.demo.swagger.model.SwaggerPath;
import com.wilson.demo.swagger.model.SwaggerTag;
import io.swagger.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service：封装拼接动态查询
 * <li>目标：整合成完整的Swagger</li>
 * <li>使用方式：装载至Controller调用</li>
 * <li>现有bug：无</li>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class SwaggerService {
    @Autowired
    private MockMongoDao dao;

    /**
     * 拼接Swagger
     * @return Swagger Json
     */
    public String getSwagger() {
        JSONObject swagger = dao.querySwagger().getJson();

        List<SwaggerTag> swaggerTagList = dao.queryTags();
        List<Tag> tagList = new ArrayList<>();
        for (SwaggerTag tag : swaggerTagList) {
            tagList.add(tag.getJson());
        }
        swagger.put("tags", tagList);

        List<SwaggerPath> swaggerPathList = dao.queryPaths();
        JSONObject pathJson = new JSONObject();
        for (SwaggerPath path : swaggerPathList) {
            pathJson.putAll(path.getJson());
        }
        swagger.put("paths", pathJson);

        List<SwaggerModel> swaggerModelList = dao.queryModels();
        JSONObject modelJson = new JSONObject();
        for (SwaggerModel model : swaggerModelList) {
            modelJson.putAll(model.getJson());
        }
        swagger.put("definitions", modelJson);

        return swagger.toJSONString();
    }

}
