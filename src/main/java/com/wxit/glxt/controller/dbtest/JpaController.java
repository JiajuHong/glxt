package com.wxit.glxt.controller.dbtest;


import com.wxit.glxt.model.JPABean;
import com.wxit.glxt.repository.JPARepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.List;
import java.util.Optional;

@Controller
public class JpaController {

    @Resource
    JPARepository rep;

    @ResponseBody
    @GetMapping("/JPA_All")
    public List<JPABean> JPA_All(Model m){
        List<JPABean> UserList = rep.findAll();
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @ResponseBody
    @GetMapping("/JPA_fbID/{id}")
    public Optional<JPABean> fbID(@PathVariable int id, Model m) {
        Optional<JPABean> UserList = rep.findById(id);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @ResponseBody
    @GetMapping("/JPA_fbn/{name}")
    public List<JPABean> fbn(@PathVariable String name) {
        return (List<JPABean>) rep.findByUserName(name);
    }

    @ResponseBody
    @GetMapping("/JPA_Role/{role}")
    public List<JPABean> jpa_role(@PathVariable String role, Model m) {
        List<JPABean> UserList = rep.findByuserRole(role);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @GetMapping("/JPA_lbn/{name}")
    public String lbn(@PathVariable String name, Model m) {
        List<JPABean> UserList = rep.listByName(name);
        m.addAttribute("Result", UserList);
        return "dbtests/result";
    }

    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Insert")
    public String JPAInsert() {
        rep.JPAInsert("d", "d", "普通用户");
        return "写入成功";
    }

    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Delete/{name}")
    public String JPADelete(@PathVariable String name) {
        rep.JPADelete(name);
        return "删除成功";
    }

    @ResponseBody
    @Transactional
    @GetMapping("/JPA_Update/{name}&{name1}")
    public String JPAUpdate(@PathVariable String name1, @PathVariable String name) {
        rep.JPAUpdate(name1, name);
        return "修改成功";
    }

    @ResponseBody
    @GetMapping("/JPA_Example")
    public List<JPABean> JPA_Example(Model m) {
        JPABean user = new JPABean();
        user.setUserName("a");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.startsWith());

        Example<JPABean> example = Example.of(user, matcher);
        List<JPABean> UserList = rep.findAll(example);
        m.addAttribute("Result", UserList);


        return UserList;
    }

}
