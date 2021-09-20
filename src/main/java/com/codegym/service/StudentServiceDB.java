//package com.codegym.service;

import com.codegym.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//public class StudentServiceDB implements IStudentService {

//    @Autowired
//    private EntityManager entityManager;
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Student> findAll() {
//        //typedQuery
//        String qr = "SELECT c FROM Student AS c";
//        TypedQuery<Student> query = entityManager.createQuery(qr, Student.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Student student) {
//        Session session = null;
//        Transaction transaction = null;
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        session.save(student);
//        transaction.commit();
//    }
//}
