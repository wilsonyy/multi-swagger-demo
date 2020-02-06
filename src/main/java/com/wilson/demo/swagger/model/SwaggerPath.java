package com.wilson.demo.swagger.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Model：Swagger路径描述
 * <li>目标：抽象出供分段存储的模型</li>
 * <li>使用方式：自行new</li>
 * <li>现有bug：无</li>
 * <pre>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "json": {
 * 	           "/users": {
 * 		           "get": {
 * 			           "summary": "查询用户",
 * 			           "tags": ["tag1"],
 * 			           "produces": ["application/json"],
 *      	           "consumes": ["application/json],
 * 			           "description": "。。。。。",
 * 			           "responses": {
 * 				           "200": {"description": "Success"},
 * 				           "400": {"description": "Bad request"},
 * 				           "401": {"description": "Unauthorized"},
 * 				           "500": {"description": "Internal Server Error"},
 * 				           "403": {"description": "Forbidden"},
 * 				           "404": {"description": "Not found"}
 * 				       },
 * 			           "parameters": [{
 * 				           "in": "query",
 * 				           "name": "userName",
 * 				           "description": "用户名称",
 * 				           "type": "string",
 * 				           "required": true
 * 			           }]
 *                 }
 * 	           }
 *         }
 *     }
 * </pre>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class SwaggerPath {
    private String id;
    private String swaggerId;
    private String name;
    private JSONObject json;
}
