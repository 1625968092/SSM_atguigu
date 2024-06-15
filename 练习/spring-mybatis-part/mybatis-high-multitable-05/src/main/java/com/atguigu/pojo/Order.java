package com.atguigu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private Integer orderId;
  private String orderName;
  private Integer customerId;


  //一个订单对应一个客户，使用这个客户对象来装对象
  private Customer customer;// 体现的是对一的关系

}  