package com.atguigu.share;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 共享域数据获取
 */
@RequestMapping("/share")
@ResponseBody
@Controller
public class ShareController {

    @Autowired
    private ServletContext servletContext;

    //方法一：原生获取
    public void data(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session
                       ){
    }



    //方法二：SpringMVC提供的方式获取,针对request提供了几种方案(了解即可)
    //model  modelMap   map   modelAndView
    public void data1(Model model) {
        model.addAttribute("key","value"); //传到request共享域
    }

    public void data2(ModelMap modelMap) {
        modelMap.addAttribute("key","value"); //传到request共享域
    }

    public void data3(Map map) {
        map.put("key","value"); //传到request共享域
    }

    public ModelAndView data4() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key","value"); //传到request共享域
        modelAndView.setViewName("视图名称/页面名称");
        return modelAndView;
    }
}
