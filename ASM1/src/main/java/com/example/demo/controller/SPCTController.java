package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.SPCTRespo;
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
@RequestMapping("san-pham-chi-tiet")
public class SPCTController {
    private SPCTRespo respo = new SPCTRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<SanPhamChiTiet> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "san-pham-chi-tiet/hien-thi";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("data") SanPhamChiTiet sp){
        return "san-pham-chi-tiet/add";
    }
    @PostMapping("story")
    public String story(Model model,@Valid SanPhamChiTiet sp,BindingResult valid){
        if (valid.hasErrors()){
            List<FieldError> fieldErrorList = valid.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",sp);
            model.addAttribute("errors",errors);
            return "san-pham-chi-tiet/add";
        }
        this.respo.create(sp);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        SanPhamChiTiet sp = this.respo.findById(id);
        model.addAttribute("data",sp);
        return "san-pham-chi-tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model,@Valid SanPhamChiTiet sp, BindingResult validdate){
        if (validdate.hasErrors()){
            List<FieldError> fieldErrorList = validdate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",sp);
            model.addAttribute("errors",errors);
            return "san-pham-chi-tiet/edit";
        }
        this.respo.update(sp);
        return "redirect:/san-pham-chi-tiet/index";
    }
}
