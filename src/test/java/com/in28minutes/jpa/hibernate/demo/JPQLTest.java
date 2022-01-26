package com.in28minutes.jpa.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@ExtendWith(SpringExtension.class)
@SpringBootTest

	public class JPQLTest {

		private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		EntityManager em;

		@Test
		public void jpql_basic() {
			Query query = em.createQuery("Select  c  From Course c");
			List resultList = query.getResultList();
			logger.info("Select  c  From Course c -> {}",resultList);
		}

		@Test
		public void jpql_typed() {
			TypedQuery<Course> query = 
						em.createQuery("Select  c  From Course c", Course.class);
			
			List<Course> resultList = query.getResultList();
			
			logger.info("Select  c  From Course c -> {}",resultList);
		}

		@Test
		public void jpql_where() {
			TypedQuery<Course> query = 
						em.createQuery("Select  c  From Course c where name like '%100 Steps'", Course.class);
			
			List<Course> resultList = query.getResultList();
			
			logger.info("Select  c  From Course c where name like '%100 Steps'-> {}",resultList);
			//[Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
		}
}
