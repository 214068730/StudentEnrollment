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
import com.enrollment.domain.StudentCourse;
import com.enrollment.domain.Department;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Roles;
import com.enrollment.domain.Student;
import com.enrollment.domain.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCourseController extends AbstractTestNGSpringContextTests{
  
	String BASE_COURSE = "http://localhost:8080/enrollment/studentCourse";
	String BASE_ADDRESS = "http://localhost:8080/enrollment/address/create";
	String BASE_STUDENT = "http://localhost:8080/enrollment/student/create";
	String BASE_LECTURER = "http://localhost:8080/enrollment/lecturer/create";
	String BASE_SUBJECT = "http://localhost:8080/enrollment/subject/create";
	String BASE_DEPARTMENT = "http://localhost:8080/enrollment/department/create";
	String BASE_ROLE = "http://localhost:8080/enrollment/roles/create";
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreateCourse() throws Exception{
		String url = BASE_COURSE + "/create";
		
		//create address
		Address address = new Address("30", "Thulani Street", "Khayelitsha", "7467");
		Address updatedAddress = restTemplate.postForObject(BASE_ADDRESS, address, Address.class);
		Assert.assertNotNull(updatedAddress);
		
		//
		//create role 
		Roles role = new Roles();
	    role.setRole("A");
	    Roles createRole = restTemplate.postForObject(BASE_ROLE, role, Roles.class);
	    
		//create student
		Student student = new Student("29387383", "Kebogile", "Moreng", updatedAddress,"959",createRole);
		
		
		
		Student updatedStudent = restTemplate.postForObject(BASE_STUDENT, student, Student.class);
		Assert.assertNotNull(updatedStudent);
		
		//create Lecturer
		Lecturer lecturer = new Lecturer("Tiaan", "Smith");
		Lecturer updatedLecturer = restTemplate.postForObject(BASE_LECTURER, lecturer, Lecturer.class);
		Assert.assertNotNull(updatedLecturer);
		
		//create subject
		Subject subject = new Subject("Information Systems IV", "INL40DB", updatedLecturer);
		Subject updatedSubject = restTemplate.postForObject(BASE_SUBJECT, subject, Subject.class);
		Assert.assertNotNull(updatedSubject);
		
		//create department
		Department department = new Department("IT Department");
		Department updatedDepartment = restTemplate.postForObject(BASE_DEPARTMENT, department, Department.class);
		Assert.assertNotNull(updatedDepartment);
		
		//create course
		StudentCourse course = new StudentCourse("NPI40RP", "Information Technology: Software Development", updatedStudent, updatedSubject, updatedDepartment);
		StudentCourse updatedCourse = restTemplate.postForObject(url, course, StudentCourse.class);
		Assert.assertNotNull(updatedCourse);
	}
	
	@Test(dependsOnMethods = "testCreateCourse")
	public void testFindById() throws Exception{
		String url = BASE_COURSE + "/{id}";
		StudentCourse course = restTemplate.getForObject(url, StudentCourse.class, "1");
		Assert.assertNotNull(course);
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
		String url = BASE_COURSE + "/{id}";
		StudentCourse course = restTemplate.getForObject(url, StudentCourse.class, "1");
		Assert.assertNotNull(course);
		
		course.setCourseCode("DET40AB");
		restTemplate.put(BASE_COURSE + "/update", course);
		StudentCourse updatedCourse = restTemplate.getForObject(url, StudentCourse.class, "1");
		Assert.assertNotNull(updatedCourse);
		Assert.assertEquals("DET40AB", updatedCourse.getCourseCode());
	}
	
	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception{
		String url = BASE_COURSE + "/findAll";
		List<StudentCourse> courses = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(courses.size() > 0);
	}
	
	@Test(dependsOnMethods = "testFindAll")
	public void testDelete() throws Exception{
		String url = "http://localhost:8080/enrollment/course/delete/{id}";
		restTemplate.delete(url, 1);
		StudentCourse deletedCourse = restTemplate.getForObject(url, StudentCourse.class, "1");
		Assert.assertNull(deletedCourse);
	}
}
