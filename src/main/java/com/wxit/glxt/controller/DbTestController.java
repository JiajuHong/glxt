package com.wxit.glxt.controller;


import com.wxit.glxt.model.UserBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class DbTestController {
    @Resource
    JdbcTemplate jdbcTemplate;


    @GetMapping("/Temp_All_result")
    public String Temp_All_result(Model m) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tbluser");
        m.addAttribute("Result", list);
        return "dbtests/result";
    }

    @GetMapping("/Temp_Bean")
    public String temp_bean(Model m) {
        String sql = "select * from tbluser";
        // 通过jdbcTemplate查询数据库
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List<UserBean> UserList = jdbcTemplate.query(sql, rowMapper);
        m.addAttribute("Result", UserList);
        return "dbtests/result";
    }
}
