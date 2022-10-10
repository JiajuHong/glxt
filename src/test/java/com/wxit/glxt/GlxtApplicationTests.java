package com.wxit.glxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GlxtApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        Connection conn = null;
        try {
            conn =dataSource.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            throw new RuntimeException("连接失败！！！", e);
        }
    }


    @Resource
    JdbcTemplate jdbcTemplate;
    @Test
    public void temptest() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tbluser");
        System.out.println(list);
    }

}
