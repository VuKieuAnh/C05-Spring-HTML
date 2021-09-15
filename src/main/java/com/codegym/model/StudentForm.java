package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private int id;
    private String name;
    private String email;
    private MultipartFile img;

    public StudentForm() {
    }

    public StudentForm(int id, String name, String email, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
