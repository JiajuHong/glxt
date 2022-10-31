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


    /**
     * 登录
     *
     * @param userName
     * @param userPass
     * @return UserBean
     * @Author jiaju
     */
    @Override
    public UserBean login(String userName, String userPass) {
        return userMapper.login(userName, userPass);
    }

    @Override
    public int register(UserBean users) {
        List<UserBean> userList = userMapper.findByuserName(users.getUserName());

        // 判断用户名是否重复
        if (userList.isEmpty()) {
            return userMapper.register(users);
        } else {
            return -1;
        }

    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public int updateUser(UserBean user) {
        return userMapper.updateUser(user);
    }

    @Override
    public UserBean findByid(int id) {
        return userMapper.findByid(id);
    }

    @Override
    public List<UserBean> findByuserName(String userName) {
        return userMapper.findByuserName(userName);
    }
}
