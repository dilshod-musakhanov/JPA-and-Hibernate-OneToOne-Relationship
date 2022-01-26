package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=DemoApplication.class)
public class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	//if one of the below operations fails then we do not want the rest to be completed
	//either all operations should succeed or all changes should be rolled back
	//for that reason too we use @Transactional 
	
	@Transactional
	public void someTest() {
		
	    //Database operation -Retrieve student
		Student student = em.find(Student.class, 20001L);
		
		//Database operation -Retrieve passport
		Passport passport =  student.getPassport();
		
		//Database operation -Update student
		student.setName("Ranga - updated");
		
		//Database operation -Update passport
		passport.setNumber("E1234567");
		
	}
	
	
	//eager fetching
	//example below
	//even if you commented student.getPassport like //logger.info("passport -> {}", student.getPassport());
	//still it will load all associated properties to student, including passport details
	//in order to change it add @OneToOne(fetch=fetchType.LAZY) on top of private Passport passport
	//in Student.java
	
	@Test
	@Transactional
	public void retriveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	@Test
	@Transactional
	public void retrivePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("passport -> {}", passport.getStudent());
	}
}
