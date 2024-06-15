package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //当前属性对应逻辑删除的字段
    //0未删除  1已经删除
    @TableLogic("deleted")
    private int deleted;
    @Version
    private int version;
}
