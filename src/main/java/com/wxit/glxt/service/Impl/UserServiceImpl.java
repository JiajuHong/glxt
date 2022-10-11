package com.wxit.glxt.service.Impl;

import com.wxit.glxt.mapper.UserMapper;
import com.wxit.glxt.model.domain.UserBean;
import com.wxit.glxt.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<UserBean> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserBean login(String userName, String userPass) {
        return userMapper.login(userName, userPass);
    }

    @Override
    public int register(UserBean users) {
        return userMapper.register(users);
    }
}
