package com.enrollment.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tblSubject")
public class Subject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subjectID;

	private String subjectName;

	private String subjectCode;

	@OneToOne
	@JoinColumn(name = "lectureID")
	private Lecturer lecturer;

	public Subject() {
	}

	public Subject(long subjectID, String subjectName, String subjectCode,
			Lecturer lecturer) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.lecturer = lecturer;
	}

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
}
