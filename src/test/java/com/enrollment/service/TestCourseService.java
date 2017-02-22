package com.enrollment.service;

import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Course;
import com.enrollment.domain.Department;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Student;
import com.enrollment.domain.Subject;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCourseService extends AbstractTestNGSpringContextTests{
	@Autowired
	CourseService courseService;
	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	LecturerService lecturerService;
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void testCreateCourse() throws Exception {
		Course course = new Course();
		
		Student student = new Student();
		student.setStudentID(23L);
		student.setStudentName("Hope");
		student.setStudentSurname("Molemo");
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
		course.setDepartment(createDepartment);
		
		course.setId(32L);
		course.setCourseName("Information Technology");
		course.setCourseCode("PGT30DD");
		Course createCourse = courseService.create(course);
		Assert.assertNotNull(createCourse);
	}
	
	@Test(dependsOnMethods = "testCreateCourse")
	public void testUpdateCourse() throws Exception{
		Course course = courseService.readById(1L);
		
		if (course != null)
		{
			course.setCourseCode("SDI38OP");
			Course updatedCourse = courseService.update(course);
			Assert.assertEquals(updatedCourse.getCourseCode(), "SDI38OP");
		}
	}
	
	@Test(dependsOnMethods = "testUpdateCourse")
	public void testReadAllCourses() throws Exception{
		Iterable<Course> course = courseService.readAll();
		Assert.assertNotNull(course);
	}
	
	@Test(dependsOnMethods = "testReadAllCourses")
	public void testDeleteCourse() throws Exception{
		Course course = courseService.readById(1L);
		
		if (course != null)
		{
			courseService.delete(course);
			Course deletedCourse = courseService.readById(1L);
			Assert.assertNull(deletedCourse);
		}
	}
}