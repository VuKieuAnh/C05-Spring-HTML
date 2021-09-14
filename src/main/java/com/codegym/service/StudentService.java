package com.codegym.service;

import com.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {

    private static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Ngoc Anh", "abc@gmail.com"));
        students.add(new Student(2, "Huy Anh", "abc1@gmail.com"));
        students.add(new Student(3, "Huy Nam", "abc2@gmail.com"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
}
