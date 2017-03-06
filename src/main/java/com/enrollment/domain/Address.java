package com.enrollment.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tblAddress")
public class Address implements Serializable {

	 
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long addressID;
	
	private String streetNumber;

	private String streetName;

	private String surbubName;

	private String areaCode;

	public Address() {
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Address(String streetNumber, String streetName, String surbubName,
			String areaCode) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.surbubName = surbubName;
		this.areaCode = areaCode;
	}

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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return addressID == address.addressID;

    }

    @Override
    public int hashCode() {
        return (int) (addressID ^ (addressID >>> 32));
    }
}
