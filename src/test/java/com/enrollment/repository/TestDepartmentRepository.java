package com.enrollment.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Department;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDepartmentRepository extends AbstractTestNGSpringContextTests{
  
	@Autowired
	DepartmentRepository repo;
	
	@Test
	public void testCreateDepartment() throws Exception{
		
		Department department = new Department();
		
		department.setDepartmentID(1L);
		department.setDepartmentName("Health");
		
		Department result = repo.save(department);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateDepartment")
	public void testUpdateDepartment() throws Exception{
		
		Department department = repo.findOne(1L);
		
		if (department != null)
		{
			department.setDepartmentName("Management");
			Department updatedDepartment = repo.save(department);
			Assert.assertEquals(updatedDepartment.getDepartmentName(), "Management");
		}
	}
	
	@Test(dependsOnMethods = "testUpdateDepartment")
	public void testReadAllDepartments() throws Exception{
		
		Iterable<Department> departments = repo.findAll();
		Assert.assertNotNull(departments);
	}
	
	@Test(dependsOnMethods = "testReadAllDepartments")
	public void testDeleteDepartment() throws Exception{
		
		Department department = repo.findOne(1L);
		
		if (department != null)
		{
			repo.delete(department);
			Department deletedDepartment = repo.findOne(1L);
			Assert.assertNull(deletedDepartment);
		}
	}
}
