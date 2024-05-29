package com.fpoly.hello1.buoi56.controller;

import com.fpoly.hello1.buoi56.entity.Country;
import com.fpoly.hello1.buoi56.entity.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("staff",new Staff());
        return "staff/staff";
    }

    @PostMapping("/form")
    public String save(Model model, @Valid @ModelAttribute("staff") Staff staff, BindingResult res) {
        if (res.hasErrors()) {
//            model.addAttribute("message1","Luu tc");
            return "staff/staff";
        }
        model.addAttribute("message","Luu tc");
        return "staff/staff";
    }

    @ModelAttribute("positions")
    public Map<String,String> getPositions() {
        Map<String,String> map= new HashMap<>();
        map.put("sv","sinh vien");
        map.put("gv","giao vien");
        map.put("dn","doanh nhan");
        return map;
    }

    @ModelAttribute("hobbies")
    public String[] getHobbies() {
        String[] arr = {"an","choi","hoc"};
        return arr;
    }

    @ModelAttribute("countries")
    public List<Country> getCountry() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("vn","VietNam"));
        countries.add(new Country("vn1","VietNam1"));
        countries.add(new Country("vn2","Vietam2"));
        return countries;
    }
}
