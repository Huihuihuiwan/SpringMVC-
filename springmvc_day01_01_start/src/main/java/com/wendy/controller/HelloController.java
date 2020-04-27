package com.wendy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    //hello就是请求路径
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello Springmvc");
        return "success";
    }
    //success默认jsp文件的名字

    /**
     * RequestMapping注解
     *
     * params:请求的时候，必须带上参数，否则会出现400错误
     * <a href="user/testRequestMapping?username=hehe">RequestMapping注解</a>
     * 在？的后面传递一个参数，要求参数必须一样，否则会报错
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",params = {"username=hehe"},headers = "Accept")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解。。");
        return "success";
    }
}
