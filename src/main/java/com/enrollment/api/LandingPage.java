package com.enrollment.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.domain.Address;
import com.enrollment.domain.Student;

@RestController
@RequestMapping("/")
public class LandingPage {
	 @RequestMapping(method = RequestMethod.GET)
	 public Student getStudent(){
		 Address address = new Address();
		 Student student = new Student();
		 
		 //setting address
		 address.setStreetName("Sparrow Street");
		 address.setStreetNumber("15");
		 address.setSurbubName("Southern Suburbs");
		 address.setAreaCode("RCKLS");
		 
		 //setting student
		 student.setStudentAddress(address);
		 student.setStudentID(15L);
		 student.setStudentName("Siraaj");
		 student.setStudentSurname("Wilkinson");
		 student.setStudentNumber("214068730");
		 
		 return student;
	 }
}
