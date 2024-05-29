package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.KichThuocRespo;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    private KichThuocRespo respo = new KichThuocRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<KichThuoc> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "kich-thuoc/hien-thi";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") KichThuoc ms){
        return "kich-thuoc/add";
    }

    @PostMapping("store")
    public String store(Model model, @Valid KichThuoc ms,  BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",ms);
            model.addAttribute("errors",errors);
            return "kich-thuoc/add";
        }
        this.respo.create(ms);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        KichThuoc ms =this.respo.findById(id);
        model.addAttribute("data",ms);
        return "kich-thuoc/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid KichThuoc ms,  BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",ms);
            model.addAttribute("errors",errors);
            return "kich-thuoc/add";
        }
        this.respo.update(ms);
        return "redirect:/kich-thuoc/index";
    }
}
