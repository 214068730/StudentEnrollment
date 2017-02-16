package com.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.Async;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.enrollment.domain.Address;
import com.enrollment.domain.Student;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class App extends WebMvcConfigurerAdapter {
	final static Student student = new Student();

	public static void main(String[] args) {
		// SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
		Address address = new Address();
		address.setAreaCode("RCKLS");
		address.setStreetName("Sparrow");
		address.setStreetNumber("15");
		address.setSurbubName("Rocklands");

		student.setStudentAddress(address);
		student.setStudentID(275L);
		student.setStudentName("Siraaj");
		student.setStudentNumber("214068730");
		student.setStudentSurname("Wilkinson");
		
		create();

	}

	private static void create() {
		try{
		final String url = "http://localhost:8080/enrollment/student/create";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Student> httpEntity = new HttpEntity<>(student, headers);
		restTemplate.postForObject(url, httpEntity, Student.class);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
