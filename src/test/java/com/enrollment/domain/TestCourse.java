package com.enrollment.domain;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class TestCourse extends TestCase{
	
	final static Course course = new Course();
	final static Department department = new Department();
	
	@Test
	public void testCreateCourse() throws Exception{
		
		Assert.assertNotNull(course);
		
		course.setCourseCode("PPD3EB");
		course.setCourseName("Software Development");
		course.setId(87L);
		
		department.setDepartmentID(56L);
		department.setDepartmentName("Information Technology");
				
		Assert.assertEquals("PPD3EB", course.getCourseCode());
		Assert.assertEquals("Software Development", course.getCourseName());
	}
	
	@Test
	public void testUpdateCourse() throws Exception{
		
		course.setCourseCode("RTS30TF");
		course.setCourseName("Web Management");
		course.setId(53L);
		
		department.setDepartmentID(23L);
		department.setDepartmentName("Management");
		
		Assert.assertEquals("RTS30TF", course.getCourseCode());
		Assert.assertEquals("Web Management", course.getCourseName());
	}
}
