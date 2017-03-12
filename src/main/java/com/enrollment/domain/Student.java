package com.enrollment.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tblStudent")
public class Student implements Serializable {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
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
	
	@OneToOne
	@JoinColumn(name = "roleID")
	private Roles role;

	public Student() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateCreated = dateFormat.format(date).toString();
		this.studentNumber = generateStudentNumber();

	}

	public Student(String studentName,
			String studentSurname, Address studentAddress,String studentIdNumber,Roles role) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.studentNumber =  generateStudentNumber();
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentAddress = studentAddress;
		this.studentIdNumber = studentIdNumber;
		this.role = role;
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

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	public String generateStudentNumber(){
    	int year = Calendar.getInstance().get(Calendar.YEAR);
        String modifiedYear= Integer.toString(year).substring(0,1);
        DateFormat dateFormat = new SimpleDateFormat("yyHHmmss");
		Date date = new Date();
		return modifiedYear+dateFormat.format(date);
    }
}
