package com.example.jpa.hibernate.jpahibernate.repository;

import com.example.jpa.hibernate.jpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    private EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public List<Course> findAll(){
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c", Course.class);
        return query.getResultList();
    }

    public void deleteById(long id){
        Course c = findById(id);
        entityManager.remove(c);
    }

    public Course save(Course course){
        if(Long.valueOf(course.getId()) == null){
            entityManager.persist(course);
        } else{
            entityManager.merge(course);
        }
        return course;
    }
}
