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

import com.enrollment.domain.Subject;
import com.enrollment.domain.SubjectCourse;
import com.enrollment.service.SubjectCourseService;

@RestController
@RequestMapping(value = "/enrollment")
public class SubjectCourseController {

	@Autowired
	SubjectCourseService service;

	// find by id
	@RequestMapping(value = "subjectCourse/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SubjectCourse findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// find by course code
	@RequestMapping(value = "subjectCourse/courseCode/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<SubjectCourse> findByCourseCode(@PathVariable Long id) {
		return service.findByCourseCourseID(id);
	}

	// insert
	@RequestMapping(value = "/subjectCourse/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public SubjectCourse create(@RequestBody SubjectCourse subjectCourse) {
		return service.create(subjectCourse);
	}

	// update
	@RequestMapping(value = "/subjectCourse/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody SubjectCourse subjectCourse) {
		service.update(subjectCourse);
	}

	// find All
	@RequestMapping(value = "/subjectCourse/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<SubjectCourse> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "subjectCourse/delete/{id}", method = {
			RequestMethod.GET, RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.OK)
	public void deleteSubjectCourse(@PathVariable("id") Long id) {
		SubjectCourse deleteSubjectCourse = service.readById(id);
		if (deleteSubjectCourse != null) {
			service.delete(deleteSubjectCourse);
		}
	}

}
