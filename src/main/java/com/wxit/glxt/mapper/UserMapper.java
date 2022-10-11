package com.wxit.glxt.mapper;

import com.wxit.glxt.model.domain.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserBean> findAll();

    UserBean login(String userName, String userPass);
}
