package com.example.demo.controller;

import com.example.demo.respository.NhanVienRespo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    NhanVienRespo nhanVienRespo = new NhanVienRespo();

    @GetMapping ("/dang-xuat")
    public String dangXuat(HttpServletRequest req) {
        req.getSession().setAttribute("nhanvien",null);
        return "redirect:/dang-nhap";
    }
}
