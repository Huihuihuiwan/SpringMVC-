package com.wendy.controller;

import com.wendy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 15:43
 */
//账户web层
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("表现层：查询所有账户....");

        //调用service
        accountService.findAll();

        return "list";
    }
}
