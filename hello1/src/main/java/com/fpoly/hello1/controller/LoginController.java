package com.fpoly.hello1.controller;

import com.fpoly.hello1.request.LoginRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/form")
    public String form() {
        return "user/login";
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(HttpServletRequest request) {
//        System.out.println("test");
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String address = request.getParameter("address");
//        if (Integer.valueOf(age) > 18 ) {
//            request.setAttribute("name",name);
//            request.setAttribute("age",age);
//            request.setAttribute("address",address);
//            return "user/info";
//        }
//        request.setAttribute("err","Không đủ tuổi đăng kí");
//        return "user/login";
//    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestParam("name") String name,
//                        @RequestParam("age") Integer age,
//                        @RequestParam("address") String address,
//                        Model model) {
//        if(age > 18) {
//            model.addAttribute("name",name);
//            model.addAttribute("age",age);
//            model.addAttribute("address",address);
//            return "user/info";
//        }
//        model.addAttribute("err","Không đủ tuổi đăng kí");
//        return "user/login";
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(LoginRequest request, Model model) {
        String name = request.getName();
        Integer age = request.getAge();
        String address = request.getAddress();
        if(age > 18) {
            model.addAttribute("name",name);
            model.addAttribute("age",age);
            model.addAttribute("address",address);
            return "user/info";
        }
        model.addAttribute("err","Không đủ tuổi đăng kí");
        return "user/login";
    }
}
