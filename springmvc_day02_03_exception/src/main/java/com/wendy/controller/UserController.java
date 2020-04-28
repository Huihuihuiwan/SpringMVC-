package com.wendy.controller;

import com.wendy.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author : wendy_wan
 * Created : 2020/4/27 17:50
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException方法执行了.....");
        try {
            //模拟异常
            int a = 10/0;

        }catch (Exception e){
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现错误....");
        }
        return "success";
    }
}
