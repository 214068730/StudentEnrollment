package com.enrollment.api;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestLecturerController extends AbstractTestNGSpringContextTests{
	
	String BASE_URL = "http://localhost:8080/enrollment/lecturer";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreate() throws Exception{
		String url = BASE_URL + "/create";
		Lecturer lecturer = new Lecturer("Kebogile", "Moreng");
		restTemplate.postForObject(url, lecturer, Lecturer.class);
	}
	
	@Test(dependsOnMethods = "testCreate")
	public void testFindById() throws Exception{
		String url = BASE_URL + "/{id}";
		Lecturer lecturer = restTemplate.getForObject(url, Lecturer.class, "1" );
		Assert.assertNotNull(lecturer);
		Assert.assertEquals("Kebogile", lecturer.getName());
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
		String url = BASE_URL + "/{id}";
		Lecturer lecturer = restTemplate.getForObject(url, Lecturer.class, "1");
		Assert.assertNotNull(lecturer);
		lecturer.setSurname("Gutsa");
		restTemplate.put(BASE_URL + "/update", lecturer);
		Lecturer updateLecturer = restTemplate.getForObject(url, Lecturer.class, "1");
		Assert.assertEquals("Gutsa", updateLecturer.getSurname());		
	}
	
	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception{
		String url = BASE_URL + "/findAll";
		List<Lecturer> lecturers = restTemplate.getForObject(url, List.class);
		Assert.assertTrue(lecturers.size() > 0);
	} 
	
	@Test(dependsOnMethods = "testFindAll")
	public void testDelete() throws Exception{
		String url = "http://localhost:8080/enrollment/lecturer/delete/{id}";
		restTemplate.delete(url, 1);
		Lecturer lecturer = restTemplate.getForObject(url, Lecturer.class, "1");
		Assert.assertNotNull(lecturer);
	}
}
