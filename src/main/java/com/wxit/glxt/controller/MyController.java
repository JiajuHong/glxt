package com.wxit.glxt.controller;

import com.wxit.glxt.model.domain.UserBean;
import com.wxit.glxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/goupdate/{id}") // 去修改页面，回显数据
    public String goupdate(@PathVariable int id, Model m) {
        UserBean user = userServiceImpl.findByid(id);
        m.addAttribute("User", user);
        return "/updateuser";
    }

    @GetMapping("/update") // 修改用户
    public String update(UserBean users, @RequestParam("id") int id, @RequestParam("name") String uname,
                         @RequestParam("pass") String upass, @RequestParam("role") String urole) {
        users.setId(id);
        users.setUserName(uname);
        users.setUserPass(upass);
        users.setUserRole(urole);
        userServiceImpl.updateUser(users);
        return "redirect:/edituser";
    }

    @GetMapping("/goselect") // 查询界面
    public String goselect() {
        return "findUser";
    }

    @GetMapping("/select") // 根据用户名查询
    public String select(Model m, @RequestParam("name") String userName) {
        List<UserBean> userList = userServiceImpl.findByuserName(userName);
        m.addAttribute("Result", userList);
        return "edituser";
    }
}
