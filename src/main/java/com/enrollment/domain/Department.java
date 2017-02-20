package com.enrollment.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "tblDepartment")
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long departmentID;
	String departmentName;
	String dateAdded;

	public Department() {
		this.dateAdded =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	}

	public Department(Long departmentID, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.dateAdded =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
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
	
	public String getDateAdded(){
		return  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	}
}
