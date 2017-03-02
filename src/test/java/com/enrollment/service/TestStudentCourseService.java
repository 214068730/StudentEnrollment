package com.enrollment.service;

import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Address;
import com.enrollment.domain.StudentCourse;
import com.enrollment.domain.Department;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Roles;
import com.enrollment.domain.Student;
import com.enrollment.domain.Subject;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentCourseService extends AbstractTestNGSpringContextTests{
	@Autowired
	StudentCourseService courseService;
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	LecturerService lecturerService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	RolesService rolesService;
	@Autowired
	AddressService addressService;
	
	@Test
	public void testCreateCourse() throws Exception {
		StudentCourse course = new StudentCourse();
		
		Address address = new Address("30", "Thulani Street", "Khayelitsha", "7467");
		Address updatedAddress = addressService.create(address);
		
		Roles role = new Roles();
	    role.setRole("A");
	    Roles roleCreated = rolesService.create(role);
		
		Student student = new Student();
		student.setStudentID(23L);
		student.setStudentName("Hope");
		student.setStudentSurname("Molemo");
		student.setStudentAddress(updatedAddress);
		student.setRole(roleCreated);
		Student createStudent = studentService.create(student);
		Assert.assertNotNull(createStudent);
		course.setStudent(createStudent);
		
		Subject subject = new Subject();
		subject.setSubjectID(25L);
		subject.setSubjectCode("OPG30BB");
		subject.setSubjectName("Development Software III");
		Subject createSubject = subjectService.create(subject);
		Assert.assertNotNull(createSubject);
		course.setSubject(createSubject);
				
		Department department = new Department();
		department.setDepartmentID(4L);
		department.setDepartmentName("Management");
		Department createDepartment = departmentService.create(department);
		Assert.assertNotNull(createDepartment);
		
	
	}
	
	@Test(dependsOnMethods = "testCreateCourse")
	public void testUpdateCourse() throws Exception{
		StudentCourse course = courseService.readById(1L);
		
//		if (course != null)
//		{
//			course.setCourseCode("SDI38OP");
//			StudentCourse updatedCourse = courseService.update(course);
//			Assert.assertEquals(updatedCourse.getCourseCode(), "SDI38OP");
//		}
	}
	
	@Test(dependsOnMethods = "testUpdateCourse")
	public void testReadAllCourses() throws Exception{
		Iterable<StudentCourse> course = courseService.readAll();
		Assert.assertNotNull(course);
	}
	
	@Test(dependsOnMethods = "testReadAllCourses")
	public void testDeleteCourse() throws Exception{
		StudentCourse course = courseService.readById(1L);
		
		if (course != null)
		{
			courseService.delete(course);
			StudentCourse deletedCourse = courseService.readById(1L);
			Assert.assertNull(deletedCourse);
		}
	}
}
