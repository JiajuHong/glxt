package com.wxit.glxt.service;

import com.wxit.glxt.model.domain.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> findAll();

    // 登录
    UserBean login(String userName, String userPass);

    // 注册
    int register(UserBean users);

    // 删除用户
    int delUser(int id);

    // 修改用户
    int updateUser(UserBean user);

    UserBean findByid(int id);

}
