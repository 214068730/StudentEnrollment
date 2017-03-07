package com.enrollment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.domain.Address;
import com.enrollment.domain.Course;
import com.enrollment.service.Impl.CourseServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class CourseController {

	@Autowired
	private CourseServiceImpl service;

	// find by id
	@RequestMapping(value = "course/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Course findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// find by name
	@RequestMapping(value = "course/name/{courseName}", method = RequestMethod.GET)
	@ResponseBody
	public Course findByCourseName(@PathVariable String courseName) {
		return service.findByCourseName(courseName);
	}

	// find by code
	@RequestMapping(value = "course/code/{courseCode}", method = RequestMethod.GET)
	@ResponseBody
	public Course findByCourseCode(@PathVariable String courseCode) {
		return service.findByCourseCode(courseCode);
	}

	// insert
	@RequestMapping(value = "/course/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Course create(@RequestBody Course course) {
		return service.create(course);
	}

	// update
	@RequestMapping(value = "/course/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Course course) {
		service.update(course);
	}

	// find All
	@RequestMapping(value = "/course/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Course> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "course/delete/{id}", method = { RequestMethod.GET,
			RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.OK)
	public void deleteCourse(@PathVariable("id") Long id) {
		Course course = service.readById(id);
		if (course != null) {
			service.delete(course);
		}
	}

}
