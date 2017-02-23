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
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSubjectController extends AbstractTestNGSpringContextTests{
	String BASE_SUBJECT = "http://localhost:8080/enrollment/subject";
	String BASE_LECTURER = "http://localhost:8080/enrollment/lecturer/create";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreateSubject() throws Exception {
		String url = BASE_SUBJECT + "/create";
		
		Lecturer lecturer = new Lecturer("Dorah", "Moreng");
		Lecturer createLecturer = restTemplate.postForObject(BASE_LECTURER, lecturer, Lecturer.class);
		Assert.assertNotNull(createLecturer);
		
		Subject subject = new Subject("Information Systems III", "INL30AC",createLecturer);
		Subject createSubject = restTemplate.postForObject(url, subject, Subject.class);
		Assert.assertNotNull(createSubject);
	}
	
	@Test(dependsOnMethods = "testCreateSubject")
	public void testFindById() throws Exception{
		String url = BASE_SUBJECT + "/{id}";
		Subject subject = restTemplate.getForObject(url, Subject.class, "1");
		Assert.assertNotNull(subject);
	}	
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
	
		String url = BASE_SUBJECT + "/{id}";
		Subject subject = restTemplate.getForObject(url, Subject.class, "1");
		Assert.assertNotNull(subject);
				
		subject.setSubjectCode("OND35PG");
		restTemplate.put(BASE_SUBJECT + "/update", subject);
		Subject updatedSubject = restTemplate.getForObject(url, Subject.class, "1");
		Assert.assertEquals("OND35PG", updatedSubject.getSubjectCode());
	}
	
	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception{
		String url = BASE_SUBJECT + "/findAll";
		List<Subject> subjects = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(subjects.size() > 0);
	}
	
	@Test(dependsOnMethods = "testFindAll")
	public void testDelete() throws Exception{
		String url = "http://localhost:8080/enrollment/subject/delete/{id}";
		restTemplate.delete(url, 1);
		Subject deletedSubject = restTemplate.getForObject(url, Subject.class, "1");
		Assert.assertNull(deletedSubject);
	}
}
