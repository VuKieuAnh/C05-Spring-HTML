package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//POJO
@Entity
public class Student {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String img;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Student() {
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Student(Integer id, String name, String email, String img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.img = img;
    }

    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
