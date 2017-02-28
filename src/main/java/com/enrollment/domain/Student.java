package com.enrollment.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tblStudent")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentID;

	@Column(unique = true)
	private String studentNumber;
	
	@Column(unique = true)
	private String studentIdNumber;

	private String studentName;

	private String studentSurname;
	
	private String dateCreated;

	@OneToOne
	@JoinColumn(name = "AddressID")
	private Address studentAddress;

	public Student() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateCreated = dateFormat.format(date).toString();
	}

	public Student(String studentNumber, String studentName,
			String studentSurname, Address studentAddress) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentAddress = studentAddress;
		this.dateCreated =  dateFormat.format(date).toString();
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public String getDateCreated(){
		return this.dateCreated;
	}

	public String getStudentIdNumber() {
		return studentIdNumber;
	}

	public void setStudentIdNumber(String studentIdNumber) {
		this.studentIdNumber = studentIdNumber;
	}
	
	
}
