package com.wxit.glxt.repository;

import com.wxit.glxt.model.domain.JPABean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPARepository extends JpaRepository<JPABean, Integer> {

    /**
     * 根据用户名查询
     * @param name
     * @return List
     */
    List findByUserName(String name);

    /**
     * 根据用户角色查询
     * @param Role
     */
    List<JPABean> findByuserRole(String Role);

    @Query("from tbluser where userName = ?1 order by id desc")
    List<JPABean> listByName(String name);



    @Query(value="insert into tbluser(userName, userPass, userRole) value(?1, ?2, ?3)", nativeQuery=true)
    @Modifying
    void JPAInsert(String userName, String userPass, String userRole);

    @Query(value = "delete from tbluser where userName=?1 ", nativeQuery = true)
    @Modifying
    void JPADelete(String name);

    @Query(value = "update tbluser set userName=?1 where userName=?2", nativeQuery=true)
    @Modifying
    void JPAUpdate(String name1, String name);

}
