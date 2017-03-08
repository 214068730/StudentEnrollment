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
@Table(name = "tblProgressStatus")
public class ProgressStatus implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;

	private String currentYear;
	private String startDate;
	private String endDate;
	private int active;
	private int completed;
	@ManyToOne
	@JoinColumn(name = "studentID")
	private Student student;

	@Transient
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	@Transient
	private Date date = new Date();

	public ProgressStatus() {
		super();
		this.startDate = dateFormat.format(date);
	}

	public ProgressStatus(String currentYear, int active,
			int completed, Student student) {
		super();
		this.currentYear = currentYear;
		this.startDate = dateFormat.format(date);
		this.active = active;
		this.completed = completed;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int isCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgressStatus progressStatus = (ProgressStatus) o;

        return id == progressStatus.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
