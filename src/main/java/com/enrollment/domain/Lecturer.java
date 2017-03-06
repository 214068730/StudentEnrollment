package com.enrollment.domain;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tblLecturer")
public class Lecturer implements Serializable {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	Long id;
	String lecturerName;
	String lecturerSurname;
	String dateAdded;

	public Lecturer() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateAdded =  dateFormat.format(date);
	}

	public Lecturer(String name, String surname) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.lecturerName = name;
		this.lecturerSurname = surname;
		this.dateAdded = dateFormat.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return lecturerName;
	}

	public void setName(String name) {
		this.lecturerName = name;
	}

	public String getSurname() {
		return lecturerSurname;
	}

	public void setSurname(String surname) {
		this.lecturerSurname = surname;
	}

	public String getDateAdded() {
		return this.dateAdded;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        return id == lecturer.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
