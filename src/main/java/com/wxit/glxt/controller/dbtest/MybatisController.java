package com.wxit.glxt.controller.dbtest;

import com.wxit.glxt.model.UserBean;
import com.wxit.glxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MybatisController {

    @Resource
    private UserService userServiceImpl;

    @ResponseBody
    @GetMapping("/Mybat_All")
    public List<UserBean> Mybat_All(Model m) {
        List<UserBean> UserList = userServiceImpl.findAll();
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @GetMapping("/Mybat_All_Page")
    public String Mybat_All_Page(Model m) {
        List<UserBean> UserList = userServiceImpl.findAll();
        m.addAttribute("Result", UserList);
        return "dbtests/result";
    }
}
