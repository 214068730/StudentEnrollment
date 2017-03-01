package com.enrollment.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tblStudentCourse")
public class StudentCourse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String courseCode;
	String courseName;

	@ManyToOne
	@JoinColumn(name = "studentID")
	Student student;

	@ManyToOne
	@JoinColumn(name = "subjectID")
	Subject subject;

	@OneToOne
	@JoinColumn(name = "departmentID")
	Department department;

	String dateRegistered;
	
	int totalFees = 0;

	public int getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}

	public StudentCourse() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateRegistered =  dateFormat.format(date);
	}

	public StudentCourse(String courseCode, String courseName,
			Student student, Subject subject, Department department) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.student = student;
		this.subject = subject;
		this.department = department;
		this.dateRegistered =  dateFormat.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDateRegistered() {
		return this.dateRegistered;
	}
}
