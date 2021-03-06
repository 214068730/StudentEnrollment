package com.enrollment.api;

import java.util.List;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.enrollment.App;
import com.enrollment.domain.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDepartmentController extends AbstractTestNGSpringContextTests{
 
	String BASE_URL = "http://localhost:8080/enrollment/department";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreateDepartment() {
		String url = BASE_URL + "/create";	
		
		Department department = new Department("Information Technology");
		restTemplate.postForObject(url, department, Department.class);
		Assert.assertNotNull(department);
	}
	
	@Test(dependsOnMethods = "testCreateDepartment")
	public void testFindById() throws Exception{
		String url = BASE_URL + "/{id}";
		Department department = restTemplate.getForObject(url, Department.class, "1");
		Assert.assertNotNull(department);
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
		String url = BASE_URL + "/{id}";
		Department department = restTemplate.getForObject(url, Department.class, "1");
		Assert.assertNotNull(department);
		
		department.setDepartmentName("Management");
		restTemplate.put(BASE_URL + "/update", department);
		
		Department updatedDepartment = restTemplate.getForObject(url, Department.class, "1" );
		Assert.assertEquals(updatedDepartment.getDepartmentName(), "Management");
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testFindAll() throws Exception{
		String url = BASE_URL + "/findAll";
		List<Department> departments = restTemplate.getForObject(url, List.class);
		Assert.assertNotNull(departments.size() > 0);
	}
}
