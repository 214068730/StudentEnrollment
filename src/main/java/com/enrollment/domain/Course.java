package com.enrollment.domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="tblCourse")
public class Course implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	String courseCode;
	String courseName;
	@ManyToOne
	Student student;
	@ManyToOne
	Subject stubject;
	@OneToOne
	Department department;
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
	public Subject getStubject() {
		return stubject;
	}
	public void setStubject(Subject stubject) {
		this.stubject = stubject;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
