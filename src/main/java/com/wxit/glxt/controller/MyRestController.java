package com.wxit.glxt.controller;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
