package com.enrollment.domain;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestStudent extends TestCase {
	
	final static Address address = new Address();
	final static Student student = new Student();
	
	@Test
	public void testCreateStudent() throws Exception{
		
		address.setAreaCode("RCKLS");
		address.setStreetName("Sparrow");
		address.setStreetNumber("15");
		address.setSurbubName("Rocklands");
		
		student.setStudentAddress(address);
		student.setStudentID(275L);
		student.setStudentName("Siraaj");
		student.setStudentNumber("214068730");
		student.setStudentSurname("Wilkinson");
		
		//Test takes place
		Assert.assertNotNull(student);
		Assert.assertEquals("Siraaj", student.getStudentName());
		Assert.assertEquals("Wilkinson", student.getStudentSurname());
		Assert.assertEquals("214068730", student.getStudentNumber());
	}
	
	@Test
	public void testUpdateStudent() throws Exception{
		
		//test old values
		Assert.assertEquals("Siraaj", student.getStudentName());
		student.setStudentName("Kebo");
		
		//test new values 
		Assert.assertEquals("Kebo", student.getStudentName());
		
	}

}
