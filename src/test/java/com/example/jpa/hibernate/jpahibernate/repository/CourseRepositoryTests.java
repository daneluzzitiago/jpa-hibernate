package com.example.jpa.hibernate.jpahibernate.repository;

import com.example.jpa.hibernate.jpahibernate.JpaHibernateApplication;
import com.example.jpa.hibernate.jpahibernate.model.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseRepositoryTests {

	@Autowired
	CourseRepository cr;

	@Test
	void findByIdShouldFindCourseHelloWorld() {
		Course course = cr.findById(1001l);
		assertEquals("Hello world", course.getName());
	}
	@Test
	@DirtiesContext //Reset data
	void deleteByIdWhenCourseExistShouldDeleteCourse() {
		cr.deleteById(1001l);
		Course course = cr.findById(1001l);
		assertNull(course);
	}
	@Test
	@DirtiesContext //Reset data
	void createWheCourseDoesNotExistsShoulCreateNewCourse() {
		Course course = cr.findById(1001l);
		course.setName("Updated");
		cr.save(course);
		course = cr.findById(1001l);
		assertNotNull(course);
		assertEquals("Updated", course.getName());
	}
}
