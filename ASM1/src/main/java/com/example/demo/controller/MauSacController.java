package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.MauSacRespo;
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
@RequestMapping("mau-sac")
public class MauSacController {
    private MauSacRespo respo = new MauSacRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<MauSac> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "mau-sac/hien-thi";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") MauSac ms){
        return "mau-sac/add";
    }

    @PostMapping("store")
    public String store(Model model, @Valid MauSac ms,  BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",ms);
            model.addAttribute("errors",errors);
            return "mau-sac/add";
        }
        this.respo.create(ms);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.deleteById(id);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        MauSac ms =this.respo.findById(id);
        model.addAttribute("data",ms);
        return "mau-sac/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid MauSac ms,  BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",ms);
            model.addAttribute("errors",errors);
            return "mau-sac/add";
        }
        this.respo.update(ms);
        return "redirect:/mau-sac/index";
    }
}
