package com.wilson.demo.swagger.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wilson.demo.swagger.service.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器：通过数据库查询动态获取Swagger文档
 * <li>目标：为前端提供动态文档</li>
 * <li>使用方式：http方式调用</li>
 * <li>现有bug：无</li>
 * @author Wilson 2020/02/06
 * @version 0.0.1
 * @since 0.0.1
 * @see SwaggerService
 */
@RestController
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    /**
     * 获取动态文档，最好加UTF-8注解，保证格式不乱码
     * @return Swagger Json字符串
     */
    @GetMapping(value = "/json", produces= "application/json;charset=UTF-8")
    public String getJson() {
        return swaggerService.getSwagger();
    }

}
