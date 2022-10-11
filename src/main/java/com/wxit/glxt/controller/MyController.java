package com.wxit.glxt.controller;

import com.wxit.glxt.model.domain.UserBean;
import com.wxit.glxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class MyController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping("/publicpage")
    public String publicPage() {
        return "publicpage";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/edituser")
    public String editUser(Model m) {
        List<UserBean> UserList = userServiceImpl.findAll();
        m.addAttribute("Result", UserList);
        return "edituser";
    }

    @GetMapping("/godel/{id}") // 删除用户
    public String delUser(@PathVariable int id) {
        userServiceImpl.delUser(id);
        return "redirect:/edituser";
    }

}
