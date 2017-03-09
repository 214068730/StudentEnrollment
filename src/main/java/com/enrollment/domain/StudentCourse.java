package com.enrollment.domain;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tblStudentCourse")
public class StudentCourse implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	Long id;

	@OneToOne
	@JoinColumn(name = "courseID")
	Course course;

	@ManyToOne
	@JoinColumn(name = "studentID")
	Student student;

	@ManyToOne
	@JoinColumn(name = "subjectID")
	Subject subject;
	

	String dateRegistered;

	public StudentCourse() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateRegistered = dateFormat.format(date);
	}

	public StudentCourse(Course course, Student student, Subject subject) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.course = course;
		this.student = student;
		this.subject = subject;

		this.dateRegistered = dateFormat.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDateRegistered() {
		return this.dateRegistered;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
