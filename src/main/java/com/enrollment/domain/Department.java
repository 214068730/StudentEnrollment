package com.enrollment.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity 
@Table(name="tblStudent")
public class Department implements Serializable  {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long departmentID;
	String departmentName;
	
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
