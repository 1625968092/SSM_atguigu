package com.atguigu.controller;


import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //Controller  + ResponseBody
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public List<User> page(@RequestParam(required = false,defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int size){
        System.out.println("page = " + page + ", size = " + size);
        return null;
    }

    @PostMapping
    public User save(@RequestBody  User user){
        return user;
    }

    @GetMapping("{id}")
    public User detail(@PathVariable("id")  Integer id){
        return null;
    }

    @PutMapping
    public User update(@RequestBody User user){
        return null;
    }

    @DeleteMapping("{id}")
    public Integer delete(@PathVariable("id") int id){
        return null;
    }

    @GetMapping("/search")
    public List<User> getUsers(@RequestParam(required = false,defaultValue = "1") int page,
                               @RequestParam(required = false,defaultValue = "10") int size,
                               @RequestParam(required = false) String keyword){
        return null;
    }

}
