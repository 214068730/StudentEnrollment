package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tblStudent")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentID;

	private String studentNumber;

	private String studentName;

	private String studentSurname;

	@Embedded
	private Address studentAddress;

	public Student() {
	}

	public Student(Long studentID, String studentNumber, String studentName,
			String studentSurname, Address studentAddress) {
		super();
		this.studentID = studentID;
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentAddress = studentAddress;
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
}
