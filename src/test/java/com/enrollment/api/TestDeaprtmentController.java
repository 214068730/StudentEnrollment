package com.enrollment.api;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.enrollment.App;
<<<<<<< HEAD
import com.enrollment.domain.Address;
import com.enrollment.domain.Department;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDeaprtmentController extends AbstractTestNGSpringContextTests{
 
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
=======
import com.enrollment.domain.Department;
import com.enrollment.domain.Lecturer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestDeaprtmentController extends AbstractTestNGSpringContextTests {

	String BASE_URL = "http://localhost:8080/enrollment/department";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testCreate() {
		String url = BASE_URL + "/create";
		Department department = new Department("Science");
		restTemplate.postForObject(url, department, Department.class);
	}

	@Test(dependsOnMethods = "testCreate")
	public void testFindById() throws Exception {
		String url = BASE_URL + "/{id}";
		Department department = restTemplate.getForObject(url,
				Department.class, "1");
		Assert.assertNotNull(department);
		Assert.assertEquals("Science", department.getDepartmentName());
	}

	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception {
		String url = BASE_URL + "/{id}";
		Department department = restTemplate.getForObject(url,
				Department.class, "1");
		Assert.assertNotNull(department);
		department.setDepartmentName("Gutsa");
		restTemplate.put(BASE_URL + "/update", department);
		Department updateDepartment = restTemplate.getForObject(url,
				Department.class, "1");
		Assert.assertEquals("Gutsa", updateDepartment.getDepartmentName());
	}
	
	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception{
		String url = BASE_URL + "/findAll";
		List<Department> departments = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(departments.size() > 0);
	} 
	
	@Test(dependsOnMethods = "testFindAll")
	public void testDelete() throws Exception{
		String url = BASE_URL+"/delete/{id}";
		restTemplate.delete(url, 1);
		Department department = restTemplate.getForObject(url, Department.class, "1");
		Assert.assertNull(department);
	}
	

>>>>>>> 45679729d92a8b6fd092ce68b37abf49b74eca6d
}
