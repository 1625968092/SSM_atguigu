package com.atguigu.service;

import com.atguigu.pojo.Headline;
import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-06-14 13:21:06
*/
public interface HeadlineService extends IService<Headline> {

    Result finNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);

    Result publish(Headline headline,long userId);

    Result findHeadlineByHid(int hid);

    Result updateData(Headline headline);
}
