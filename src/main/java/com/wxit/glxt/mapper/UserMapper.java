package com.wxit.glxt.mapper;

import com.wxit.glxt.model.domain.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserBean> findAll();

    // 登录
    UserBean login(String userName, String userPass);

    // 注册
    int register(UserBean users);

    // 根据id查询
    UserBean findByid(int id);

    // 删除
    int delUser(int id);

    // 修改
    int updateUser(UserBean users);
}
