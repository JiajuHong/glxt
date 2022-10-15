package com.wxit.glxt.repository;

import com.wxit.glxt.model.domain.JPABean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JPARepository extends JpaRepository<JPABean, Integer> {

    @Cacheable(cacheNames = "findById")
    Optional<JPABean> findById(int id);

    /**
     * 根据用户名查询
     *
     * @param name
     * @return List
     */

    @Cacheable(cacheNames = "findByUserName")
    List<JPABean> findByUserName(String name);

    /**
     * 根据用户角色查询
     *
     * @param Role
     */
    List<JPABean> findByUserRole(String Role);

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
