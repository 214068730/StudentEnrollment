package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Address implements Serializable {

	private String streetNumber;

	private String streetName;

	private String surbubName;

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
