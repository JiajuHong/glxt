package com.wxit.glxt.controller;


import com.wxit.glxt.model.UserBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {


    @Resource
    JdbcTemplate jdbcTemplate;


    @GetMapping("Temp_All")
    public List<Map<String, Object>> Temp_All(Model m) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tbluser");
        return list;
    }

    @ResponseBody
    @GetMapping("/Temp_Bean_json")
    public List<UserBean> Temp_Bean_json(Model m) {
        String sql = "select * from tbluser";
        // 通过jdbcTemplate查询数据库
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List<UserBean> UserList = jdbcTemplate.query(sql, rowMapper);
        return UserList;

    }
}
