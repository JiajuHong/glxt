package com.wxit.glxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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

}
