package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.HDCTRespo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hoa-don-chi-tiet")
public class HDCTController {
    private HDCTRespo respo = new HDCTRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<HoaDonChiTiet> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "hoa-don-chi-tiet/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDonChiTiet hd = this.respo.findById(id);
        model.addAttribute("data",hd);
        return "hoa-don-chi-tiet/edit";
    }
    @PostMapping("update")
    public String update(Model model, @Valid HoaDonChiTiet hd, BindingResult valid, HttpServletRequest req) {
        if (valid.hasErrors()) {
            List<FieldError> fieldErrorList = valid.getFieldErrors();
            Map<String, String> map = new HashMap<>();
            for (FieldError error : fieldErrorList) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("data", hd);
            model.addAttribute("errors", map);
            return "hoa-don-chi-tiet/edit";
        }
        NhanVien nv = (NhanVien) req.getSession().getAttribute("nhanvien");
        if (nv.getTrangThai() == 0) {
            return "redirect:/no-role";
        }
        this.respo.update(hd);
        return "redirect:/hoa-don-chi-tiet/index";
    }
}
