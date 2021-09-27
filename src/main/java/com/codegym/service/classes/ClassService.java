package com.codegym.service.classes;

import com.codegym.model.Classes;
import com.codegym.repo.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassService implements IClassesService {
    @Autowired
    private IClassRepository classRepository;
    @Override
    public Iterable<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public void save(Classes classes) {
        classRepository.save(classes);
    }

    @Override
    public void delete(Integer id) {
        classRepository.deleteById(id);
    }

    @Override
    public Classes findById(Integer id) {
        return classRepository.findById(id).get();
    }
}
