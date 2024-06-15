package com.atguigu.test;

import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void testToOne() {
            // 查询订单和对应客户
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());


    }

    @Test
    public void testToDuo() {
        // 查询订单和对应客户
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryList();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
