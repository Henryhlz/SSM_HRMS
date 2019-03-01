package com.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/2.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test",  method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        System.out.println("测试。。。");
        return "test";
    }
}
