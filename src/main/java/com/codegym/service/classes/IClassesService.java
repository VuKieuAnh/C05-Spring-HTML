package com.codegym.service.classes;

import com.codegym.model.Classes;

public interface IClassesService {
    Iterable<Classes> findAll();
    void save(Classes student);
    Classes findById(Integer id);
}
