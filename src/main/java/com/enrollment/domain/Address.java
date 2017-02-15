package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "tblAddress")
public class Address implements Serializable 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "Street Number")
	private String streetNumber;
	
	@Column(name = "Street Name")
	private String streetName;
	
	@Column(name = "Surbub Name")
	private String surbubName;
	
	@Column(name = "Area Code")
	private String areaCode;
	
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getSurbubName() {
		return surbubName;
	}
	public void setSurbubName(String surbubName) {
		this.surbubName = surbubName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
}
