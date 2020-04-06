package com.example.jpa.hibernate.jpahibernate.repository;

import com.example.jpa.hibernate.jpahibernate.model.Course;
import com.example.jpa.hibernate.jpahibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    private EntityManager em;

    public List<Student> findAll(){
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }
}
