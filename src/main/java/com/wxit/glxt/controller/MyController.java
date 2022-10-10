package com.wxit.glxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {

    @GetMapping("/publicpage")
    public String publicPage() {
        return "publicpage";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
