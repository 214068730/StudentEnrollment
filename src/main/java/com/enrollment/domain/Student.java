package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name= "tblStudent")
public class Student implements Serializable  
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "ID")
	private long studentID;
	
	@Column (name = "Student Number")
	private Long studentNumber;
	
	@Column (name = "Student Name")
	private String studentName;
	
	@Embedded
	@Column (name = "Student Address")
	private Address studentAddress;
	
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
	public Long getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Long studentNumber) {
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
