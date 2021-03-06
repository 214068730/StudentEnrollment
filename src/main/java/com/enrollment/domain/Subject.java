package com.enrollment.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "tblSubject")
public class Subject implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long subjectID;

	private String subjectName;

	private String subjectCode;

	private String dateAdded;
	
	private double price;
	
	private int yearLevel;

	@OneToOne
	@JoinColumn(name = "lectureID")
	private Lecturer lecturer;

	public Subject() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateAdded = dateFormat.format(date);
	}

	public Subject(String subjectName, String subjectCode, double price,
			int yearLevel, Lecturer lecturer) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.lecturer = lecturer;
		this.dateAdded = dateFormat.format(date);
		this.price = price;
		this.yearLevel = yearLevel;
		
	}

	public Long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Long subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public String getDateAdded() {
		return this.dateAdded;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearCode() {
		return yearLevel;
	}

	public void setYearCode(int yearCode) {
		this.yearLevel = yearCode;
	}
	
	
	
}
