package com.enrollment.domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tblDepartment")
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long departmentID;
	String departmentName;

	public Department() {
	}

	public Department(Long departmentID, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
