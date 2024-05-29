package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrController {

    @GetMapping("/no-role")
    public String noRole() {
        return "norole";
    }

    @GetMapping("/no-login")
    public String noLogin() {
        return "nologin";
    }
}
