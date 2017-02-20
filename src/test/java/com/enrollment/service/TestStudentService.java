package com.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Address;
import com.enrollment.domain.Student;


@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentService extends AbstractTestNGSpringContextTests {
  
	@Autowired
	StudentService service;
	
	@Test
	public void testCreateStudent() throws Exception{
		Address address = new Address();
		Student student = new Student();
		
		address.setAreaCode("4530");
		address.setStreetName("Delport Street");
		address.setStreetNumber("12");
		address.setSurbubName("Wetton");
		
		student.setStudentAddress(address);
		student.setStudentID(3L);
		student.setStudentName("Matthew");
		student.setStudentNumber("2839744");
		student.setStudentSurname("Kok");
		
		Student result = service.create(student);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateStudent")
	public void testUpdateStudent() throws Exception{
		Student student = service.readById(1L);
		
		if (student != null)
		{
			student.setStudentSurname("Smith");
			Student updatedStudent = service.create(student);
			Assert.assertEquals("Smith", updatedStudent.getStudentSurname());
		}
	}
	
	@Test(dependsOnMethods = "testUpdateStudent")
	public void testReadAllStudents() throws Exception{
		Iterable<Student> students = service.readAll();
		Assert.assertNotNull(students);
	}
	
	@Test(dependsOnMethods = "testReadAllStudents")
	public void testDeleteStudent() throws Exception{
		Student student = service.readById(1L);
		
		if (student != null)
		{
			service.delete(student);
			Student deletedStudent = service.readById(1L);
			Assert.assertNull(deletedStudent);
		}
	}	
}
