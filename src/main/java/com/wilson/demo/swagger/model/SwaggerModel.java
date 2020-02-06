package com.wilson.demo.swagger.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Model：Swagger模型描述
 * <li>目标：抽象出供分段存储的模型</li>
 * <li>使用方式：自行new</li>
 * <li>现有bug：无</li>
 * <pre>
 *     {
 * 	       "id": "1",
 * 	       "swaggerId": "aaa",
 * 	       "name": "返回结果",
 * 	       "json": {
 * 		       "resultDto": {
 * 			       "properties": {
 * 				       "msg": {
 * 					       "default": "成功",
 * 					       "type": "string"
 *                     },
 * 				       "code": {
 * 					       "default": "000000",
 * 					       "type": "string"
 *                     },
 * 				       "data": {
 * 					       "type": "object"
 *                     }
 *                 }
 * 		       }
 *         }
 *     }
 *
 * </pre>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class SwaggerModel {
    private String id;
    private String swaggerId;
    private String name;
    private JSONObject json;
}
