package com.enrollment.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;

import com.enrollment.App;
import com.enrollment.domain.Address;
import com.enrollment.domain.Student;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentRepository extends AbstractTestNGSpringContextTests {

	@Autowired
	StudentRepository repo;
	@Autowired
	AddressRepository addressRepo;
	
	@Test
	public void testCreateStudent()throws Exception {
		Student student = new Student();
		Address address = new Address();
		
		address.setAreaCode("RCKLS");
		address.setStreetName("Sparrow");
		address.setStreetNumber("15");
		address.setSurbubName("Rocklands");
		Address createAddress = addressRepo.save(address);

		student.setStudentAddress(createAddress);
		student.setStudentID(275L);
		student.setStudentName("Siraaj");
		student.setStudentNumber("214068730");
		student.setStudentSurname("Wilkinson");
		
		Student result = repo.save(student);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateStudent")
	public void testStudentUpdate() throws Exception{
		Student student = repo.findOne(1L);
        if(student != null)
        {
            student.setStudentSurname("Wilkinson");
            Student updatedStudent =repo.save(student);
            Assert.assertEquals(updatedStudent.getStudentSurname(),"Wilkinson");
        }
	}
	
	@Test(dependsOnMethods = "testStudentUpdate")
	public void testReadAllStudents() throws Exception{
		Iterable<Student> students =  repo.findAll();
        Assert.assertNotNull(students);
	}
		
	@Test(dependsOnMethods = "testReadAllStudents")
	public void testDeleteStudent() throws Exception{
		Student student = repo.findOne(1L);
        if(student != null)
        {
            repo.delete(student);
            Student deletedStudent = repo.findOne(1L);
            Assert.assertNull(deletedStudent);
        }
	}	
}
