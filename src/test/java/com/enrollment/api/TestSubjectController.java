package com.enrollment.api;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSubjectController extends AbstractTestNGSpringContextTests {

	String BASE_URL = "http://localhost:8080/enrollment/subject";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreate() {
		String url =BASE_URL+"create";
		Subject subject = new Subject();
	}
}
