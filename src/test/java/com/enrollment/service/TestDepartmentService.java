package com.enrollment.service;

import org.testng.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Department;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDepartmentService extends AbstractTestNGSpringContextTests{
	@Autowired
	DepartmentService service;
	
	@Test
	public void testCreateDepartment() throws Exception {
		Department department = new Department();
		
		department.setDepartmentID(65L);
		department.setDepartmentName("Human Resources");
		
		Department result = service.create(department);
		Assert.assertNotNull(result);		
	}
	
	@Test(dependsOnMethods = "testCreateDepartment")
	public void testUpdateDepartment() throws Exception{
		Department department = service.readById(1L);
		
		if (department != null)
		{
			department.setDepartmentName("Education");
			Department updatedDepartment = service.update(department);
			Assert.assertEquals(updatedDepartment.getDepartmentName(), "Education");
		}
	}	
	
	@Test(dependsOnMethods = "testUpdateDepartment")
	public void testReadAllDepartments() throws Exception{
		Iterable<Department> department = service.readAll();
		Assert.assertNotNull(department);
	}
	
	@Test(dependsOnMethods = "testReadAllDepartments")
	public void testDeleteDepartment() throws Exception{
		Department department = service.readById(1L);
		
		if (department != null)
		{
			service.delete(department);
			Department deletedDepartment = service.readById(1L);
			Assert.assertNull(deletedDepartment);
		}
	}
}
