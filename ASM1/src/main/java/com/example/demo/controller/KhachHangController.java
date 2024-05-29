package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPhamChiTiet;
import com.example.demo.respository.KhachHangRespo;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    private KhachHangRespo respo = new KhachHangRespo();

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                        @RequestParam(name = "search", defaultValue = "") String search) {
        model.addAttribute("currentPage",currentPage);
        List<KhachHang> listAfterSearch = respo.search(search,respo.findAll());
        model.addAttribute("lastPage",respo.getLastPage(listAfterSearch));
        model.addAttribute("search",search);
        model.addAttribute("data",respo.getByPage(currentPage,listAfterSearch));
        return "khach-hang/hien-thi";
    }

    @GetMapping("create")
    public String viewAdd(@ModelAttribute("data") KhachHang kh){
        return "khach-hang/add";
    }

    @PostMapping("add")
    public  String add(Model model, @Valid KhachHang kh, BindingResult validate){
        if (validate.hasErrors()){
            List<FieldError> fieldErrorList = validate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",kh);
            model.addAttribute("errors",errors);
            return "khach-hang/add";
        }
        this.respo.add(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.respo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        KhachHang kh =this.respo.findById(id);
        model.addAttribute("data",kh);
        return "khach-hang/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, @Valid KhachHang kh,  BindingResult validate){
        if (validate.hasErrors()){
            List<FieldError> fieldErrorList = validate.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrorList){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("data",kh);
            model.addAttribute("errors",errors);
            return "khach-hang/add";
        }
        this.respo.update(kh);
        return "redirect:/khach-hang/index";
    }
}
