package com.wilson.demo.swagger.model;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.Tag;
import lombok.Getter;
import lombok.Setter;

/**
 * Model：Swagger标签
 * <li>目标：抽象出供分段存储的模型</li>
 * <li>使用方式：自行new</li>
 * <li>现有bug：无</li>
 * <pre>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "json": {"name": "tag1", "description": "test"}
 *     }
 * </pre>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class SwaggerTag {
    private String id;
    private String swaggerId;
    private Tag json;
}
