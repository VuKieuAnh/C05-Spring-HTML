package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    Iterable<Student> findAll();
    void save(Student student);
}
