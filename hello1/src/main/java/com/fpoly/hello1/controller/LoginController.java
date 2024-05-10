package com.fpoly.hello1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping("user/form")
    public String form() {
        return "user/login";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        System.out.println("test");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        if (Integer.valueOf(age) > 18 ) {
            request.setAttribute("name",name);
            request.setAttribute("age",age);
            request.setAttribute("address",address);
            return "user/info";
        }
        request.setAttribute("err","Không đủ tuổi đăng kí");
        return "user/login";
    }
}
