package com.atguigu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  private Integer customerId;
  private String customerName;

  //一个客户对应多个订单
  //对多装对方类型的list集合
  private List<Order> orderList;


}