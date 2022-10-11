package com.wxit.glxt.service;

import com.wxit.glxt.model.domain.UserBean;

import java.util.List;

public interface UserService {
    public List<UserBean> findAll();

    // 注册
    public UserBean login(String userName, String userPass);

    // 登录
    public int register(UserBean users);

}
