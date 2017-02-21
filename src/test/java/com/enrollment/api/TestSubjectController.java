package com.enrollment.api;


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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSubjectController extends AbstractTestNGSpringContextTests{
  
	String BASE_URL = "http://localhost:8080/enrollment/subject";
	String BASE_LECTURER = "http://localhost:8080/enrollment/lecturer/create";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreate() throws Exception{
		String url = BASE_URL + "/create";
	
		Lecturer lecturer = new Lecturer(1L, "Kebogile", "Moreng");
		restTemplate.postForObject(BASE_LECTURER, lecturer, Lecturer.class);
		
		Subject subject = new Subject(1L, "Development Software IV", "OPG40BB", lecturer);
		restTemplate.postForObject(url, subject, Subject.class);
		//Assert.assertNotNull(subject);
	}
	
	@Test(dependsOnMethods = "testCreate")
	public void testFindById() throws Exception{
		String url = BASE_URL + "/{id}";
		Subject subject = restTemplate.getForObject(url, Subject.class, "1");
		Assert.assertNotNull(subject);
		Assert.assertEquals("Development Software IV", subject.getSubjectName());		
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
		
	}
}