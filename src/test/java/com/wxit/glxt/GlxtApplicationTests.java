package com.wxit.glxt;

import com.wxit.glxt.mapper.CommentMapper;
import com.wxit.glxt.mapper.UserMapper;
import com.wxit.glxt.model.domain.UserBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Resource
    CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
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

    @Test
    public void tempQuery() {
        String sql = "select id, userName, userPass, userRole from tbluser where id=?";
        BeanPropertyRowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        UserBean user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(user);
    }

    @Test
    /**
     * 测试insert
     */
    public void tempInsert() {
        String sql = "insert into tbluser(userName, userPass, userRole) values('a', 'b', '普通用户')";
        jdbcTemplate.update(sql);
        System.out.println("写入成功");
    }

    @Test
    /**
     * 测试delete
     */
    public void tempDelete() {
        String sql = "delete from tbluser where userName='a'";
        jdbcTemplate.update(sql);
        System.out.println("删除成功");
    }

    @Test
    /**
     * 测试update
     */
    public void tempUpdate() {
        String sql = "update tbluser set userPass='999' where userName='a'";
        jdbcTemplate.update(sql);
        System.out.println("修改成功");
    }

    @Test
    public void testMybatFindall() {
        List<UserBean> list = userMapper.findAll();
        System.out.println(list);
    }


    @Test
    public void selectComment() {
        UserBean user = commentMapper.findbyId(10);
        System.out.println(user);
    }

    @Test
    public void insertComment() {
        commentMapper.insert("a", "a", "普通用户");
        System.out.println("写入成功");
    }

    @Test
    public void deleteComment() {
        commentMapper.delete(26);
        System.out.println("删除成功");
    }


    @Test
    public void updateComment() {
        commentMapper.update("a02", "123", "管理员", 32);
        System.out.println("修改成功");
    }
}
