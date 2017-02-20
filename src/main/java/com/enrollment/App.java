package com.enrollment;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.enrollment.domain.Address;
import com.enrollment.domain.Course;
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

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Hello World!");

	}

}
