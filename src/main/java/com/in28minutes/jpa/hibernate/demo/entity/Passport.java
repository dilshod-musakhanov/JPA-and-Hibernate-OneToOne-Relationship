package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	//to make Student an owning side of relationship we add 'mappedBy'
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	
	protected Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
	}
}
