package com.enrollment.repository;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Address;
import com.enrollment.domain.Course;
import com.enrollment.domain.Department;
import com.enrollment.domain.Roles;
import com.enrollment.domain.Student;
import com.enrollment.domain.Subject;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCourseRepository extends AbstractTestNGSpringContextTests{
	
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	DepartmentRepository departmentRepo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	SubjectRepository subjectRepo;
	@Autowired
	AddressRepository addressRepo;
	@Autowired
	RolesRepository rolesRepo;
	
	
	@Test
    public void testCreateCourse() throws Exception {
		
		Course course = new Course();
		
		Address address = new Address("30", "Thulani Street", "Khayelitsha", "7467");
		Address createdAddress = addressRepo.save(address);
		
		Roles role = new Roles();
	    role.setRole("A");
	    Roles createRole = rolesRepo.save(role);
		
		Student student = new Student();
		student.setStudentID(1L);
		student.setStudentName("Kebogile");
		student.setStudentSurname("Moreng");
		student.setStudentNumber("20282828");
		student.setStudentIdNumber("959040");
		student.setStudentAddress(address);
		student.setRole(createRole);
		Student createStudent = studentRepo.save(student);
		Assert.assertNotNull(createStudent);
		course.setStudent(createStudent);
		
		Subject subject = new Subject();
		subject.setSubjectID(1L);
		subject.setSubjectCode("OND32AB");
		subject.setSubjectName("Information Systems IV");
		Subject createSubject = subjectRepo.save(subject);
		Assert.assertNotNull(createSubject);
		course.setSubject(createSubject);
		
		Department department = new Department();
		department.setDepartmentID(1L);
		department.setDepartmentName("Database");
		Department createDepartment = departmentRepo.save(department);
		Assert.assertNotNull(createDepartment);
		course.setDepartment(createDepartment);
		
		course.setId(1L);
		course.setCourseCode("PPC30AB");
		course.setCourseName("Information Technology");
		
		//save the course
		Course result = courseRepo.save(course);
		Assert.assertNotNull(result);
    }
	
	@Test(dependsOnMethods = "testCreateCourse")
	public void testUpdateCourse() throws Exception{
		
		Course course = courseRepo.findOne(1L);
		Student student = course.getStudent();
				
		if (course != null)
		{
			//set new value for student surname
			student.setStudentSurname("Kalake");
			
			//set new value for student's course name
			course.setCourseName("Electrical Engineering");
			course.setStudent(student);
			
			Student updatedStudent = course.getStudent();
			Course updatedCourse = courseRepo.save(course);
			
			Assert.assertEquals("Electrical Engineering", updatedCourse.getCourseName());
			Assert.assertEquals("Kalake", updatedStudent.getStudentSurname());	
		}
	}
	
	@Test(dependsOnMethods = "testUpdateCourse")
	public void testReadAllCourses() throws Exception{
		
		Iterable<Course> course = courseRepo.findAll();
		Assert.assertNotNull(course);
	}
	
	@Test(dependsOnMethods = "testReadAllCourses")
	public void testStudentCourse() throws Exception{
		List<Course> course = courseRepo.findByStudentStudentID(2L);
		Assert.assertNotNull(course);
		
	}	
	
	@Test(dependsOnMethods = "testStudentCourse")
	public void testDeleteCourse() throws Exception{
		
		Course course = courseRepo.findOne(1L);
		
		if (course != null)
		{
			courseRepo.delete(course);
			Course deletedCourse = courseRepo.findOne(1L);
			Assert.assertNull(deletedCourse);
		}
	}	
}
