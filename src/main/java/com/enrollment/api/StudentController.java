package com.enrollment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.enrollment.domain.Student;
import com.enrollment.service.Impl.StudentServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class StudentController {

	@Autowired
	StudentServiceImpl service;

	// find by id
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Student findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/student/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Student create(@RequestBody Student student) {
		return service.create(student);
	}

	// update
	@RequestMapping(value = "/student/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Student student) {
		service.update(student);
	}

	// find All
	@RequestMapping(value = "/student/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> findAll() {
		return service.readAll();
	}
	
	//login
	@RequestMapping(value = "/student/findAll/{studentNumber}/{studentName}", method = RequestMethod.GET)
	@ResponseBody
	public Student findLogin(@PathVariable String studentNumber,@PathVariable String studentName) {
		return service.findByStudentNumberAndStudentName(studentNumber, studentName);
	}
	
	//findByStudentNumber
	@RequestMapping(value = "/student/findByStudentNumber/{studentNumber}", method = RequestMethod.GET)
	@ResponseBody
	public Student findByStudentNumber(@PathVariable String studentNumber) {
		return service.findByStudentNumber(studentNumber);
	}

	// delete
	@RequestMapping(value = "/student/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
	@ResponseStatus(HttpStatus.OK)
	public void deleteCourse(@PathVariable("id") Long id) {
		Student deleteStudent = service.readById(id);
		if (deleteStudent != null) {
			service.delete(deleteStudent);
		}
	}

}
