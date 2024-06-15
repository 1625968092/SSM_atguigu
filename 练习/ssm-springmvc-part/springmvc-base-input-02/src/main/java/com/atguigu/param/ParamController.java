package com.atguigu.param;


import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/param")
public class ParamController {

    //直接接收
    //形参列表填写对应名称即可
    //1.名称需要相同  2.可以不传递，不报错
    @RequestMapping("/data")
    @ResponseBody
    public String data(String name,int age){
        System.out.println("name = " + name+"age = " + age);
        return "name = " + name+"age = " + age;
    }

    //注解指定
    //指定任意参数名，要求必须传递 要求不必传递 给与一个默认值

    /**
     * @RequestParam  -- >  形参列表  指定请求参数名 或者是否必须传递 或者非必须传递，设置默认值
     *                  用法：@RequestParam(value = "account")  指定请求名称
     *                      @RequestParam(required = true,defaultValue = "1") 设置是否必须传参，是否有默认值
     */
    @GetMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String account,
                        @RequestParam(required = true,defaultValue = "1") int page){
        return "name = " + account+"age = " + page;
    }
    //特殊值
    //一名多值   爱好  hbs等等
    //param/data2?hbs=chi&hbs=wan&hbs=tangtou
    @GetMapping("data2")
    @ResponseBody
    //必须加入 @RequestParam@RequestParam 注解
    //不加注解会将 hbs的字符串直接赋值给List集合   报类型异常错误
    public String data2(@RequestParam List<String> hbs){
        return hbs.toString();
    }

    //使用实体对象接值   用户注册信息  ---->   对应的实体类  ---->  插入到数据库
    //param/data3?name="二狗子"&age=18   准备一个对应实体类 有get set方法
    @RequestMapping("/data3")
    @ResponseBody
    public String data3(User user){
        System.out.println(user);
        return user.toString();
    }




}
