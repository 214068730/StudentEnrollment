package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tblSubject")
public class Subject implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long subjectID;
	
	@Column(name = "Subject Name")
	private String subjectName;
	
	@Column(name = "Lecturer")
	@OneToMany
	private Lecturer lecturer;
	
	public long getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}	
}
