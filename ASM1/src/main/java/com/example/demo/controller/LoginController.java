package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.respository.NhanVienRespo;
import com.example.demo.respository.SanPhamRespo;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    NhanVienRespo nhanVienRespo = new NhanVienRespo();

    @GetMapping("/dang-nhap")
    public String viewDangNhap() {
        return "login";
    }

    @PostMapping("/dang-nhap")
    public String dangNhap(@RequestParam("un") String un,
                           @RequestParam("pw") String pw,
                           Model model,
                           HttpServletRequest req) {
        String res = nhanVienRespo.dangNhap(un,pw);
        if (res == null) {
            req.getSession().setAttribute("nhanvien",nhanVienRespo.nv);
        } else {
            model.addAttribute("err",res);
            return "login";
        }
        return "redirect:/trang-chu";
    }
}
