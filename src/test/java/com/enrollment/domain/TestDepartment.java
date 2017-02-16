package com.enrollment.domain;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDepartment extends TestCase{

	final static Department department = new Department();
	
	@Test
	public void testCreateDepartment() throws Exception{
		
		Assert.assertNotNull(department);
		
		department.setDepartmentID(7L);
		department.setDepartmentName("Information Technology");
		
		Assert.assertEquals("Information Technology", department.getDepartmentName());	
	}
	
	@Test
	public void testUpdateDepartment() throws Exception{
		
		department.setDepartmentID(56L);
		department.setDepartmentName("Marketing");
		
		Assert.assertEquals("Marketing", department.getDepartmentName());
	}
}
