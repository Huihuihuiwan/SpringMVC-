package com.wendy.controller;

import com.wendy.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * Author : wendy_wan
 * Created : 2020/4/1 12:35
 */
@Controller
@RequestMapping("/anno")
/*
* //把meimei存入session域中，
* 本来只有request域中有msg，
* 使用注解之后session域中也有msg信息
* */
@SessionAttributes(value = {"msg"})
public class AnnoController {

    /*
    * @RequestParam注解：将jsp文件中传递的（name = "uname"）赋值给username
    * 不加注解，必须保证username与jsp文件参数的参数相同，否则封装不了数据
    * */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "uname") String username){
        System.out.println("执行了....");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了....");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了....");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了....");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
        public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了....");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注释
     * @param
     * @return
     */
    @RequestMapping("/testModelAttribute")
    /*
    * @ModelAttribute("abc")从map集合中取出abc数据
     * */
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了....");
        System.out.println(user);
        return "success";
    }

    /**
     * @ModelAttribute
     * 出现在方法上，表示当前方法会在控制器的方法执行之前，先执行
     * @param uname

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了....");
        //通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    } */

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了....");
        //通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
        //return user;
    }

    /**
     * SessionAttributes注解
     * 向model中存数据，实际上是存放在request域对象中
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了....");
        //底层会存储到request域对象中，当数据存完之后，会跳转到jsp文件
        model.addAttribute("msg","meimei");
        return "success";
    }

    /**
     * 从session域中取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了....");
        //底层会存储到request域对象中，当数据存完之后，会跳转到jsp文件
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行了....");
        //底层会存储到request域对象中，当数据存完之后，会跳转到jsp文件
        status.setComplete();
        return "success";
    }
}
