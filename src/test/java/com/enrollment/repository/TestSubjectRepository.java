package com.enrollment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Student;
import com.enrollment.domain.Subject;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSubjectRepository extends AbstractTestNGSpringContextTests{
  
	@Autowired
	SubjectRepository repo;
	@Autowired 
	LecturerRepository lectureRepo;
	
	@Test
	public void testCreateSubject() throws Exception {
		
		Subject subject = new Subject();
		Lecturer lecturer = new Lecturer();
				
		//lecturer.setId(9L);
		lecturer.setName("Kebogile");
		lecturer.setSurname("Potlaki");
		
		subject.setLecturer(lecturer);
		subject.setSubjectCode("OND45PP");
		subject.setSubjectName("Research Methodology IV");
		
		//save the subject in the database
		lectureRepo.save(lecturer);
		Subject result = repo.save(subject);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateSubject")
	public void testUpdateSubject() throws Exception{
		
		Subject subject = repo.findOne(1L);
		Lecturer lecturer = subject.getLecturer();
		
		if (subject != null)
		{
			lecturer.setSurname("Gutsa");
			subject.setSubjectName("Technical Programming III");
			subject.setSubjectCode("PPC89UI");
			subject.setLecturer(lecturer);
			Lecturer updatedLecturer = subject.getLecturer();
			
			Subject updatedSubject = repo.save(subject);
            Assert.assertEquals(updatedSubject.getSubjectName(),"Technical Programming III");
            Assert.assertEquals(updatedSubject.getSubjectCode(), "PPC89UI");
            Assert.assertEquals("Gutsa",updatedLecturer.getSurname());
		}
	}
	
	@Test(dependsOnMethods = "testUpdateSubject")
	public void testReadAllSubjects() throws Exception{
		Iterable<Subject> subjects =  repo.findAll();
        Assert.assertNotNull(subjects);
	}
	
	@Test(dependsOnMethods = "testReadAllSubjects")
	public void testDeleteSubject() throws Exception{
		Subject subject = repo.findOne(1L);
		
		if (subject != null)
		{
			repo.delete(subject);
			Subject deletedSubject = repo.findOne(1L);
			Assert.assertNull(deletedSubject);
		}		
	}
}
