package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.respository.SanPhamRespo;
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
@RequestMapping("san-pham")
public class SanPhamController {
    private SanPhamRespo respo = new SanPhamRespo();

    @GetMapping("index/{trangThai}")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search,
                        @PathVariable(name = "trangThai") int trangThai) {
        model.addAttribute("currentPage",currentPage);
        List<SanPham> listAfterSearch = respo.search(search,respo.findAll());
        List<SanPham> listAfterCheckConHang = respo.checkConHang(trangThai,listAfterSearch);
        model.addAttribute("lastPage",respo.getLastPage(listAfterCheckConHang));
        model.addAttribute("trangThai",trangThai);
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterCheckConHang));
        return "san-pham/hien-thi";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") SanPham sp){
        return "san-pham/add";
    }
    @PostMapping("story")
    public String story(Model model, @Valid SanPham sp, BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",sp);
            model.addAttribute("errors",errors);
            return "san-pham/add";
        }
        this.respo.create(sp);
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.deleteById(id);
        return "redirect:/san-pham/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        SanPham sp = this.respo.findById(id);
        model.addAttribute("data",sp);
        return "san-pham/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model,@Valid SanPham sp, BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",sp);
            model.addAttribute("errors",errors);
            return "san-pham/add";
        }
        this.respo.update(sp);
        return "redirect:/san-pham/index";
    }
}
