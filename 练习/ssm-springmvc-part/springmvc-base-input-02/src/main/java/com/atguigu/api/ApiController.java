package com.atguigu.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ServletContext servletContext;

    public String data(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session
                       ){
        //ServletContext  [1.最大的配置文件  2.最大的共享域 3.核心API拥有者 ]
        //方案一：request、session获取
        ServletContext servletContext = request.getServletContext();

        //方案二：全局声明一个ServletContext
        return null;
    }
}
