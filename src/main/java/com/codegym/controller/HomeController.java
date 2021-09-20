package com.codegym.controller;

import com.codegym.model.Classes;
import com.codegym.model.Student;
import com.codegym.model.StudentForm;
import com.codegym.service.IStudentService;
import com.codegym.service.StudentService;
import com.codegym.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
@PropertySource("classpath:upload_file.properties")
public class HomeController {
//    IStudentService studentService = new StudentService();

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IClassesService classesService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes(){
        return classesService.findAll();
    }


    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String home(Model model){
        Iterable<Student> studentList = studentService.findAll();
        model.addAttribute("list", studentList);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView creatForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new StudentForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNewStudent(@ModelAttribute StudentForm studentForm){
        //B1: luu file vao vung nho
        //d:/kieuanh/img1.jpg
        MultipartFile multipartFile = studentForm.getImg();
        //img1.jpg
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),
                    new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //B2: Tao moi doi tuong Student tu studentForm
        Student student1 = new Student();
        student1.setImg(fileName);
        student1.setId(studentForm.getId());
        student1.setName(studentForm.getName());
        student1.setEmail(studentForm.getEmail());
        student1.setClasses(studentForm.getClasses());
        //b3: Save lai student
        studentService.save(student1);
        return "redirect:/students";
    }

//    @PostMapping("/createdemo")
//    public String createNewStudent1(int id, String name, String email1){
//        Student student = new Student(id, name, email1);
//        studentService.save(student);
//        return "redirect:/students";
//    }



//    @GetMapping("/create1")
//    public String createNewStudent1(Student student){
//        studentService.save(student);
//        return "redirect:/students";
//    }
}
