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

import com.enrollment.domain.Subject;
import com.enrollment.service.Impl.SubjectServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class SubjectController {

	@Autowired
	SubjectServiceImpl service;

	// find by id
	@RequestMapping(value = "subject/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Subject findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/subject/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Subject create(@RequestBody Subject subject) {
		return service.create(subject);
	}

	// update
	@RequestMapping(value = "/subject/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Subject subject) {
		service.update(subject);
	}

	// find All
	@RequestMapping(value = "/subject/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Subject> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "subject/delete/{id}", method ={RequestMethod.GET,RequestMethod.DELETE})
	@ResponseStatus(HttpStatus.OK)
	public void deleteSubject(@PathVariable("id") Long id) {
		Subject deleteSubject = service.readById(id);
		if (deleteSubject != null) {
			service.delete(deleteSubject);
		}
	}
}
