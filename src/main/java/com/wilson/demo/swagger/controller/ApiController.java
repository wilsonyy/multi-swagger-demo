package com.wilson.demo.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器：简单的通过swagger注解生成
 * <li>目标：无作用，仅为注解生成自身文档提供载体</li>
 * <li>使用方式：http方式调用</li>
 * <li>现有bug：无</li>
 * @author Wilson 2020/02/06
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api")
@Api(value = "API管理")
public class ApiController {

    @RequestMapping(method = RequestMethod.POST,value = "/userById")
    @ApiOperation(value = "获取用户信息", notes = "通过用户ID获取用户信息")
    public String findById(@ApiParam(value = "用户ID",required = true) int id){
        return "OK";
    }
}
