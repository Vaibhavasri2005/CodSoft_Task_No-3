package com.studentgrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {
    @GetMapping({"/", "/login", "/register", "/dashboard", "/calculator", "/history", "/profile"})
    public String index() {
        return "forward:/index.html";
    }
}
