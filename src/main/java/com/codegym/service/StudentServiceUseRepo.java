package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repo.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceUseRepo implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
