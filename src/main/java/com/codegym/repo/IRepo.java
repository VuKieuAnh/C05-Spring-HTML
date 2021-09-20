package com.codegym.repo;

import java.util.List;

//coi kieu du lieu nhu tham so
public interface IRepo<T> {
    List<T> findAll();
    void save(T t);
}
