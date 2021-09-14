package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class HomeController {
//    IStudentService studentService = new StudentService();

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String home(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("list", studentList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView creatForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNewStudent(Student student){
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/create1")
    public String createNewStudent1(Student student){
        studentService.save(student);
        return "redirect:/students";
    }
}
