package com.wilson.demo.swagger.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Model：Swagger主体
 * <li>目标：抽象出供分段存储的模型</li>
 * <li>使用方式：自行new</li>
 * <li>现有bug：无</li>
 * <pre>
 *     {
 * 	       "id": "aaa",
 * 	       "name": "代码生成json",
 * 	       "json": {
 * 		       "swagger": "2.0",
 * 		       "info": {
 * 			        "contact": {
 * 				        "name": "Wilson Support",
 * 				        "url": "http://www.baidu.com",
 * 				        "email": "support@wilson.com"
 *                  },
 * 			        "description": "代码生成json",
 * 			        "title": "我的Swagger REST API",
 * 			        "version": "0.0.1"*
 * 			    },
 * 		        "basePath": "/v1",
 * 		        "host": "127.0.0.1:8080",
 * 		        "schemes": ["http"]
 * 	        }
 *     }
 *
 * </pre>
 * @author Wilson 2020/02/04
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
public class SwaggerBody {
    private String id;
    private String name;
    private JSONObject json;
}
