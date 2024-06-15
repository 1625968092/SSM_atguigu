package com.atguigu.jsp;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 返回jsp模板页面
 */
@Controller
@RequestMapping("/jsp")
public class JspController {


    /**
     * 快速查找视图
     * 1. 返回值类型是字符串
     * 2. 不能添加ResponseBody 直接返回给浏览器不找视图
     * 3. 通过返回值填写对应的视图名称即可
     */
    @RequestMapping("index")
    public String index(HttpServletRequest req){
        req.setAttribute("data","this is data");
        System.out.println("index");
        return "index";
    }


    /**
     * 转发（只能是项目下的资源）
     *  1. 方法返回值为字符串
     *  2. 不能添加responseBody注解
     *  3. 返回字符串前添加 forward： /转发地址 字符串
     */
    @RequestMapping("/forward")
    public String forward(HttpServletRequest req){
        return "forward:/jsp/index";
    }


    /**
     * 重定向（可以是项目外的资源）
     *   1. 方法返回值为字符串类型
     *   2. 不能添加ResponseBody注解
     *   3. 返回字符串前添加redirect：/转发地址  字符串
     */

    @RequestMapping("/redirect")
    public String redirect(HttpServletRequest req){
        return "redirect:/jsp/index";
    }

}
