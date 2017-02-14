package com.enrollment.domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="tblLecturer")
public class Lecturer implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	String name;
	String surname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
