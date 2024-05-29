package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.NhanVienRespo;
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
@RequestMapping("nhan-vien")
public class NhanVienController {
    private NhanVienRespo respo = new NhanVienRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<NhanVien> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "nhan-vien/hien-thi";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") NhanVien nv){
        return "nhan-vien/add";
    }

    @PostMapping("store")
    public String store(Model model, @Valid NhanVien nv, BindingResult valid){
        if (valid.hasErrors()){
            List<FieldError> fieldErrorList = valid.getFieldErrors();
            Map<String,String> map = new HashMap<>();
            for (FieldError error : fieldErrorList){
                map.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",nv);
            model.addAttribute("errors",map);
            return "nhan-vien/add";
        }
        this.respo.create(nv);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.delete(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        NhanVien nv = this.respo.findById(id);
        model.addAttribute("data",nv);
        return "nhan-vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(Model model, @Valid NhanVien nv, BindingResult valid){
        if (valid.hasErrors()){
            List<FieldError> fieldErrorList = valid.getFieldErrors();
            Map<String,String> map = new HashMap<>();
            for (FieldError error : fieldErrorList){
                map.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",nv);
            model.addAttribute("errors",map);
            return "nhan-vien/edit";
        }
        this.respo.update(nv);
        return "redirect:/nhan-vien/index";
    }
}
