package com.atguigu.json;


import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/json")
@Controller
@ResponseBody
public class JsonController {


    //data  -->  请求体 post  {name,age,gender}
    //前端  -->  415  不支持媒体类型 ？
    // java原生API只支持  Param和路径传参  而不支持Json
    // 1. 导入相关依赖  jackson-bind
    // 2. handlerAdapt配置Json转换器  配置类上加 @EnableWebMvc 注解
    // 相当于添加了经理 handlerAdapter  添加秘书 handlerMapping  添加jackson处理器
    @RequestMapping("/data")
    public String data(@RequestBody Person person){
        System.out.println(person);
        return person.toString();
    }
}
