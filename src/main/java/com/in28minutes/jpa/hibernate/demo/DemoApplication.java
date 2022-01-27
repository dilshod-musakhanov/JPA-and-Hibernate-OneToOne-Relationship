package com.in28minutes.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    /*
	@Override
	public void run(String... arg0) throws Exception {
		Course course = repository.findById(10001L);
		
		logger.info("Course 10001 -> {}", course);
		
		repository.save(new Course("Microservices in 100 Steps"));
	}
	*/
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on Stuff"));
		reviews.add(new Review("5", "Hatsoff"));
		//studentRepository.saveStudentWithPassport();
		//repository.playWithEntityManager();
		//courseRepository.addHardcodeReviewsForCourse();
		courseRepository.addReviewsForCourse(10003L, reviews);
	}	
}
