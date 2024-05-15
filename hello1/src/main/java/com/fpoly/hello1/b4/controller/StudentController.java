package com.fpoly.hello1.b4.controller;

import com.fpoly.hello1.b4.entity.Student;
import com.fpoly.hello1.b4.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService sv = new StudentService();

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("student",sv.getAll());
        return "student/index";
    }

    @PostMapping("/detail")
    public String searchI(Model model,
                         @RequestParam("id") String id) {
        System.out.println("here");
        model.addAttribute("student",sv.findById(id));
        return "student/detail";
    }

    @GetMapping("/add")
    private String showAddForm() {
        return "student/form";
    }

    @PostMapping("/add")
    private String add(Student student) {
        sv.add(student);
        return "redirect:/student";
    }

    @GetMapping("/update")
    private String showUpdateForm(@RequestParam("id") String id,
                                  Model model) {
        model.addAttribute("student",sv.findById(id));
        return "student/update";
    }

    @PostMapping("/update")
    private String update(Student student) {
        sv.update(student);
        return "redirect:/student";
    }

    @GetMapping("/delete")
    private String delete(@RequestParam("id") String id) {
        sv.delete(id);
        return "redirect:/student";
    }

}
