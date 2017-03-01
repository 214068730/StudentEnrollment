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

import com.enrollment.domain.StudentCourse;
import com.enrollment.service.Impl.StudentCourseServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class StudentCourseController {

	@Autowired
	StudentCourseServiceImpl service;

	// find by id
	@RequestMapping(value = "studentCourse/{id}", method = RequestMethod.GET)
	@ResponseBody
	public StudentCourse findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/studentCourse/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StudentCourse create(@RequestBody StudentCourse course) {
		return service.create(course);
	}

	// update
	@RequestMapping(value = "/studentCourse/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody StudentCourse course) {
		service.update(course);
	}

	// find All
	@RequestMapping(value = "/studentCourse/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentCourse> findAll() {
		return service.readAll();
	}

	// find All by student id
	@RequestMapping(value = "/studentCourse/findAll/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentCourse> findAllByStudentID(@PathVariable Long id) {
		return service.findCourseByStudentNumber(id);
	}

	// delete
	@RequestMapping(value = "studentCourse/delete/{id}", method ={RequestMethod.GET,RequestMethod.DELETE})
	@ResponseStatus(HttpStatus.OK)
	public void deleteCourse(@PathVariable("id") Long id) {
		StudentCourse deleteCourse = service.readById(id);
		if (deleteCourse != null) {
			service.delete(deleteCourse);
		}
	}
}
