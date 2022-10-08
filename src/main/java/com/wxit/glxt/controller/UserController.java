package com.wxit.glxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/goregister")
    public String goregister(@RequestParam("name") String uname, @RequestParam("password") String upass) {
        return "name:"+uname+", password:"+upass+"";
    }
}
