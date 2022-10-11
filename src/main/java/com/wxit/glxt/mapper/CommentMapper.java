package com.wxit.glxt.mapper;

import com.wxit.glxt.model.domain.UserBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("select * from tbluser where id = #{id}")
    /*
     * 根据id查询
     */
    public UserBean findbyId(Integer id);

    @Insert("insert into tbluser(userName, userPass, userRole) values(#{userName}, #{userPass}, #{userRole})")
    /*
     * 插入数据
     */
    public void insert(String userName, String userPass, String userRole);


    @Delete("delete from tbluser where id = #{id}")
    /*
    删除数据
     */
    public void delete(Integer id);

    @Update("update tbluser set userName=#{userName}, userPass=#{userPass}, userRole=#{userRole} where id=#{id}")
    /*
    更新数据
     */
    public void update(String userName, String userPass, String userRole, Integer id);
}
