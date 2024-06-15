package com.atguigu.controller;

import com.atguigu.mapper.HeadlineMapper;
import com.atguigu.pojo.Headline;
import com.atguigu.service.HeadlineService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("headline")
@CrossOrigin
public class HeadlineController {

    @Autowired
    private HeadlineService headlineService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token){
        Long userId = jwtHelper.getUserId(token);
        Result result = headlineService.publish(headline,userId);
        return result;
    }
    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(@RequestParam int hid){
        Result result=headlineService.findHeadlineByHid(hid);
        return result;
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline){
        Result result=headlineService.updateData(headline);
        return result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(@RequestParam int hid){
        headlineService.removeById(hid);
        return Result.ok(null);
    }

}
