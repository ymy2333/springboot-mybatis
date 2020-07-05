package com.atguigu.controller;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.atguigu.domain.User;
import com.atguigu.service.UserSerivce;
import com.atguigu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserSerivce userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        System.out.println("userService.getClass() = " + userService.getClass());
        return userService.finaAll();
    }
}
