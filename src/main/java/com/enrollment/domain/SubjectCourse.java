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
@Table(name = "tblSubjectCourse")
public class SubjectCourse implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "courseID")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "subjectID")
	private Subject subject;

	@Transient
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	@Transient
	private Date date = new Date();

	private String dateCreated;

	public SubjectCourse() {
		super();
		this.dateCreated = dateFormat.format(date);
	}

	public SubjectCourse(Course course, Subject subject,
			String dateCreated) {
		super();
		this.course = course;
		this.subject = subject;
		this.dateCreated = dateFormat.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDateCreated() {
		return dateCreated;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectCourse subjectCourse = (SubjectCourse) o;

        return id == subjectCourse.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
	

}
