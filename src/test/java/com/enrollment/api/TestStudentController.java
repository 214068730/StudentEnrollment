package com.enrollment.api;

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
import com.enrollment.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentController extends AbstractTestNGSpringContextTests {

	String BASE_URL = "http://localhost:8080/enrollment/student";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testCreate() {
		String url = BASE_URL + "/create";
		Address address = new Address("15", "Sparrow", "ROCKLANDS", "RCKLDS");
		Student student = new Student(1L, "214068730", "Siraaj", "Wilkinson",
				address);
		restTemplate.postForObject(url, student, Student.class);
	}

	@Test(dependsOnMethods = "testCreate")
	public void testFindById() {
		String url = BASE_URL + "/{id}";
		Student student = restTemplate.getForObject(url, Student.class, "1");
		Assert.assertNotNull(student);
		Assert.assertEquals("Siraaj", student.getStudentName());

	}

	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() {
		String url = BASE_URL + "/{id}";
		Student student = restTemplate.getForObject(url, Student.class, "1");
		Assert.assertNotNull(student);
		student.setStudentName("Shireen");
		restTemplate.put(BASE_URL + "/update", student);
		Student updateStudent = restTemplate.getForObject(url, Student.class,
				"1");
		Assert.assertEquals("Shireen", updateStudent.getStudentName());
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() {
		String url = BASE_URL + "/findAll";
		List<Student> students = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(students.size() > 0);

	}

//	@Test(dependsOnMethods = "testFindAll")
//	public void testDelete() {
//		String url = "http://localhost:8080/enrollment/student/delete/{id}";
//		restTemplate.delete(url, 1);
//		Student student = restTemplate.getForObject(url, Student.class, "1");
//		Assert.assertNull(student);
//
//	}

}
