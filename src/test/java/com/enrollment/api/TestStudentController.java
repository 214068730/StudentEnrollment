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
import com.enrollment.domain.Address;
import com.enrollment.domain.Roles;
import com.enrollment.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentController extends AbstractTestNGSpringContextTests {

	String BASE_URL = "http://localhost:8080/enrollment/student";
	String BASE_ADDRESS = "http://localhost:8080/enrollment/address/create";
	String BASE_ROLE = "http://localhost:8080/enrollment/roles/create";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testCreateStudent() throws Exception {
		String url = BASE_URL + "/create";
		Long id = 1L;
		Address address = new Address("15", "Sparrow", "ROCKLANDS", "RCKLDS");
		Address updatedAddress = restTemplate.postForObject(BASE_ADDRESS,
				address, Address.class);
		Assert.assertNotNull(updatedAddress);
		Assert.assertEquals(id, updatedAddress.getAddressID());

		Roles role = new Roles();
		role.setRole("A");
		Roles createRole = restTemplate.postForObject(BASE_ROLE, role,
				Roles.class);

		Student student = new Student("214068730", "Siraaj", "Wilkinson",
				updatedAddress, "95",createRole);
		restTemplate.postForObject(url, student, Student.class);
		Assert.assertNotNull(student);
	}

	@Test(dependsOnMethods = "testCreateStudent")
	public void testFindById() throws Exception {
		String url = BASE_URL + "/{id}";
		Student student = restTemplate.getForObject(url, Student.class, "1");
		Assert.assertNotNull(student);
	}

	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception {
		// find the student by id to update
		String url = BASE_URL + "/{id}";
		Student student = restTemplate.getForObject(url, Student.class, "1");
		Assert.assertNotNull(student);

		// update a student name
		student.setStudentName("Shireen");
		restTemplate.put(BASE_URL + "/update", student);
		Student updatedStudent = restTemplate.getForObject(url, Student.class,
				"1");
		Assert.assertEquals("Shireen", updatedStudent.getStudentName());
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception {
		String url = BASE_URL + "/findAll";
		List<Student> students = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(students.size() > 0);
	}

	@Test(dependsOnMethods = "testFindAll")
	public void testDelete() throws Exception {
		String url = "http://localhost:8080/enrollment/student/delete/{id}";
		restTemplate.delete(url, 1);
		Student student = restTemplate.getForObject(url, Student.class, "1");
		Assert.assertNull(student);
	}
}
