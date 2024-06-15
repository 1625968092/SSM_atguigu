package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test01 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPageQuery(){
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void test(){
        //Ipage -> Page(第几页，一页几个)
        Page<User> userPage = new Page<>(1,3);
        userMapper.selectPage(userPage, null);

        //结果
        long current = userPage.getCurrent();
        long size = userPage.getSize();
        List<User> records = userPage.getRecords();
        long total = userPage.getTotal();


    }

    @Test
    public void test2(){
        //Ipage -> Page(第几页，一页几个)
        Page<User> userPage = new Page<>(1,3);
        userMapper.queryByAge(userPage, 20);

        //结果
        long current = userPage.getCurrent();
        System.out.println("current = " + current);
        long size = userPage.getSize();
        System.out.println("size = " + size);
        List<User> records = userPage.getRecords();
        System.out.println("records = " + records);
        long total = userPage.getTotal();
        System.out.println("total = " + total);

    }
}
