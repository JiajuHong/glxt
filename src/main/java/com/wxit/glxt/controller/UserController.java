package com.wxit.glxt.controller;

import com.wxit.glxt.model.domain.UserBean;
import com.wxit.glxt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping("/hello")
    public String hello() {
        return "你好 Spring Boot";
    }


    @PostMapping("/goregister")
    public int goregister(UserBean users, @RequestParam("name") String uname, @RequestParam("password") String upass) {
        System.out.println("name:" + uname + ", password:" + upass);
        users.setUserName(uname);
        users.setUserPass(upass);
        users.setUserRole("普通用户");
        userServiceImpl.register(users);
        return 1;
    }
}
