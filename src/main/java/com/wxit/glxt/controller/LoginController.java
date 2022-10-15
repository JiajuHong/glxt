package com.wxit.glxt.controller;

import com.wxit.glxt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

@Controller
public class LoginController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * @param username
     * @param password
     * @param session
     * @return String
     * @Author jiaju
     */
    @PostMapping("/gologin")
    public String gologin(@RequestParam("name") String username, @RequestParam("password") String password, HttpSession session) {
//        if ("admin".equals(username) && "123".equals(password)) {
//            return "登录成功";
        if (userServiceImpl.login(username, password) != null) {
            session.setAttribute("currentuser", username);
            System.out.println(username);
            return "index";
        } else {
            return "error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("currentuser");
        return "login";
    }
}
