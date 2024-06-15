package com.atguigu.service;

import com.atguigu.pojo.Type;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【news_type】的数据库操作Service
* @createDate 2024-06-14 13:21:06
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();
}
