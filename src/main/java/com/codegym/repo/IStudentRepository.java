package com.codegym.repo;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer> {
}
