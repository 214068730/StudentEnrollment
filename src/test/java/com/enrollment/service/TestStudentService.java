package com.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Address;
import com.enrollment.domain.Roles;
import com.enrollment.domain.Student;


@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentService extends AbstractTestNGSpringContextTests {
  
	@Autowired
	StudentService studentService;
	@Autowired
	AddressService addressService;
	@Autowired
	RolesService rolesService;
	
	@Test
	public void testCreateStudent() throws Exception{
		Address address = new Address();
		Student student = new Student();
		
		address.setAreaCode("4530");
		address.setStreetName("Delport Street");
		address.setStreetNumber("12");
		address.setSurbubName("Wetton");
		Address createAddress = addressService.create(address);
		Assert.assertNotNull(createAddress);
		
		Roles role = new Roles();
	    role.setRole("A");
	    Roles createRole = rolesService.create(role);
		
		student.setStudentAddress(createAddress);
		student.setRole(createRole);
		student.setStudentID(3L);
		student.setStudentName("Matthew");
		student.setStudentNumber("2839744");
		student.setStudentSurname("Kok");
		
		Student result = studentService.create(student);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateStudent")
	public void testUpdateStudent() throws Exception{
		Student student = studentService.readById(1L);
		
		if (student != null)
		{
			student.setStudentSurname("Smith");
			Student updatedStudent = studentService.create(student);
			Assert.assertEquals("Smith", updatedStudent.getStudentSurname());
		}
	}
	
	@Test(dependsOnMethods = "testUpdateStudent")
	public void testReadAllStudents() throws Exception{
		Iterable<Student> students = studentService.readAll();
		Assert.assertNotNull(students);
	}
	
	@Test(dependsOnMethods = "testReadAllStudents")
	public void testDeleteStudent() throws Exception{
		Student student = studentService.readById(1L);
		
		if (student != null)
		{
			studentService.delete(student);
			Student deletedStudent = studentService.readById(1L);
			Assert.assertNull(deletedStudent);
		}
	}	
}
