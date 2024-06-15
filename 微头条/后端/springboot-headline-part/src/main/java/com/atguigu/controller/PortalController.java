package com.atguigu.controller;

import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.service.HeadlineService;
import com.atguigu.service.TypeService;
import com.atguigu.service.UserService;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Types;

/**
 * 首页控制层
 */

@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes() {
        Result result=typeService.findAllTypes();
        return result;
    }

    @PostMapping("findNewsPage")
    public Result finNewsPage(@RequestBody PortalVo portalVo) {
        Result result=headlineService.finNewsPage(portalVo);
        return result;
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid) {
        Result result=headlineService.showHeadlineDetail(hid);
        return result;
    }
}
