package com.codegym.controller;

import com.codegym.model.Classes;
import com.codegym.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private IClassesService classesService;

    @GetMapping("/list")
    public ModelAndView index(){
        ModelAndView classes = new ModelAndView("classes/list");
        classes.addObject("classes", classesService.findAll());
        return classes;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Classes>> getAll(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Classes> create(@RequestBody Classes classes){
        classesService.save(classes);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Classes> delete(@PathVariable Integer id){
        classesService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
