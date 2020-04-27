package com.wendy.controller;

import com.wendy.controller.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : wendy_wan
 * Created : 2020/4/27 9:21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了...");
        //模拟从数据库中查询数据
        User user = new User();
        user.setUsername("meimei");
        user.setPassword("123456");
        user.setAge(25);
        //将数据存储在request域的model中
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了...");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("你好");
        return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了...");
        //模拟从数据库中查询数据
        User user = new User();
        user.setUsername("XIAOLI");
        user.setPassword("123456");
        user.setAge(25);

        //把user对象存储到mv对象中，也会把对象存入到request对象
        mv.addObject("user",user);

        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了...");
        //请求的转发
        //重定向不会执行视图解析器，所以转发的路径要写完整
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        //重定向请求不到web-inf下面的资源，只能访问webapp下面的资源
        //框架自动为重定向添加了项目路径
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了...");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //作响应，模拟查询数据库
        user.setUsername("hahaha");
        user.setAge(40);
        //作响应
        return user;
    }
}
