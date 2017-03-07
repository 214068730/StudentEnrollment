package com.enrollment.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tblCourse")
public class Course implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long courseID;

	private String courseName;
	private String courseCode;

	@ManyToOne
	@JoinColumn(name = "departmentID")
	private Department department;

	private String dateCreated;
	@Transient
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	@Transient
	private Date date = new Date();

	public Course() {
		super();
		this.dateCreated = dateFormat.format(date);
	}

	public Course(String courseName, String courseCode,
			Department department) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.department = department;
		this.dateCreated = dateFormat.format(date);
	}

	public Long getId() {
		return this.courseID;
	}

	public void setId(Long id) {
		this.courseID = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Course course = (Course) o;
//
//        return courseID == course.courseID;
//
//    }
//
//    @Override
//    public int hashCode() {
//        return (int) (courseID ^ (courseID >>> 32));
//    }

}
