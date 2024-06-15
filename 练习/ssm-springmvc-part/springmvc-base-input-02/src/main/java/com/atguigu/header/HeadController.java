package com.atguigu.header;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/header")
public class HeadController {

    @RequestMapping("/data")
    public String data(@RequestHeader String host){
        System.out.println("host = " + host);
        return "host = " + host;
    }
}
