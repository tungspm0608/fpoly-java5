package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.respository.NhanVienRespo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    NhanVienRespo nhanVienRespo = new NhanVienRespo();

    @GetMapping("/trang-chu")
    public String showTrangChu(Model model) {

        return "trang-chu";
    }
}
