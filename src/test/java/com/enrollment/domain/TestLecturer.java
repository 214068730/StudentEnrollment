package com.enrollment.domain;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestLecturer extends TestCase{
	
	final static Lecturer lecturer = new Lecturer();
	
	@Test
	public void testCreateLecturer() throws Exception{
		
		Assert.assertNotNull(lecturer);
		
		lecturer.setId(7L);
		lecturer.setName("Gail");
		lecturer.setSurname("Matthews");
		
		Assert.assertEquals("Gail", lecturer.getName());
		Assert.assertEquals("Matthews", lecturer.getSurname());		
	}
	
	@Test
	public void testUpdateLecturer() throws Exception{
		
		lecturer.setName("Lesedi");
		lecturer.setSurname("Molusi");
		
		Assert.assertEquals("Lesedi", lecturer.getName());
		Assert.assertEquals("Molusi", lecturer.getSurname());
	}
}
