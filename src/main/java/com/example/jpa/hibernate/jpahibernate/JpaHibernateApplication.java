package com.example.jpa.hibernate.jpahibernate;

import com.example.jpa.hibernate.jpahibernate.model.Course;
import com.example.jpa.hibernate.jpahibernate.model.Student;
import com.example.jpa.hibernate.jpahibernate.repository.CourseRepository;
import com.example.jpa.hibernate.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository cr;
	@Autowired
	private StudentRepository sr;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Course> c = cr.findAll();
		List<Student> s = sr.findAll();
		System.out.println(c);
		System.out.println(s);
	}
}
