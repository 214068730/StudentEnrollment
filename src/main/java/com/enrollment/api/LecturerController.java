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


import com.enrollment.domain.Lecturer;
import com.enrollment.service.Impl.LecturerServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class LecturerController {

	@Autowired
	LecturerServiceImpl service;

	// find by id
	@RequestMapping(value = "lecturer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Lecturer findById(@PathVariable Long id) {
		return service.readById(id);
	}
	
	//find by name and surname
	@RequestMapping(value = "lecturer/findByNameAndSurname/{name}/{surname}", method = RequestMethod.GET)
	@ResponseBody
	public Lecturer findByNameAndSurname(@PathVariable String name,@PathVariable String surname) {
		return service.findByLecturerNameAndLecturerSurname(name, surname);
	}

	// insert
	@RequestMapping(value = "/lecturer/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Lecturer create(@RequestBody Lecturer lecturer) {
		return service.create(lecturer);
	}

	// update
	@RequestMapping(value = "/lecturer/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Lecturer lecturer) {
		service.update(lecturer);
	}

	// find All
	@RequestMapping(value = "/lecturer/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Lecturer> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "lecturer/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
	@ResponseStatus(HttpStatus.OK)
	public void deleteLecturer(@PathVariable("id") Long id) {
		Lecturer deleteLecturer = service.readById(id);
		if (deleteLecturer != null) {
			service.delete(deleteLecturer);
		}
	}
}
