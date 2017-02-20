package com.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Subject;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSubjectService extends AbstractTestNGSpringContextTests{
  
	@Autowired
	SubjectService service;
	
	@Test
	public void testCreateSubject() throws Exception {
		Subject subject = new Subject();
		Lecturer lecturer = new Lecturer();
		
		lecturer.setId(22L);
		lecturer.setName("Lee-Anne");
		lecturer.setSurname("Hero");
		
		subject.setLecturer(lecturer);
		subject.setSubjectCode("OND23GP");
		subject.setSubjectID(23L);
		subject.setSubjectName("Information System III");
		
		Subject result = service.create(subject);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateSubject")
	public void testUpdateSubject() throws Exception{
		Subject subject = service.readById(1L);
		Lecturer lecturer = subject.getLecturer();
		
		if (subject != null)
		{
			lecturer.setSurname("Magowa");
			subject.setSubjectCode("FTP23TS");
			subject.setLecturer(lecturer);
			Lecturer updatedLecturer = subject.getLecturer();
			
			Subject updatedSubject = service.create(subject);
			Assert.assertEquals(updatedSubject.getSubjectCode(), "FTP23TS");
			Assert.assertEquals(updatedLecturer.getSurname(), "Magowa");	
		}
	}
	
	@Test(dependsOnMethods = "testUpdateSubject")
	public void testReadAllSubjects() throws Exception{
		Iterable<Subject> subjects = service.readAll();
		Assert.assertNotNull(subjects);
	}
	
	@Test(dependsOnMethods = "testReadAllSubjects")
	public void testDeleteSubject() throws Exception{
		Subject subject = service.readById(1L);
		
		if (subject != null)
		{
			service.delete(subject);
			Subject deletedSubject = service.readById(1L);
			Assert.assertNull(deletedSubject);
		}
	}
}
