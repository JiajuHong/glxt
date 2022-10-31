package com.wxit.glxt.service;

import com.wxit.glxt.model.domain.UserBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userServiceImpl;

    @Test
    void register() {
        UserBean user = new UserBean();

        String userName = "admin";
        String userPass = "123";
        String userRole = "管理员";

        user.setUserName(userName);
        user.setUserPass(userPass);
        user.setUserRole(userRole);


        int result = userServiceImpl.register(user);
        Assertions.assertEquals(-1, result);


    }
}