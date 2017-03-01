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
import com.enrollment.domain.Roles;
import com.enrollment.service.Impl.RolesServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class RolesController {

	@Autowired
	private RolesServiceImpl service;

	// find by id
	@RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Roles findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/roles/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Roles create(@RequestBody Roles role) {
		return service.create(role);
	}

	// update
	@RequestMapping(value = "/roles/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Roles role) {
		service.update(role);
	}

	// find All
	@RequestMapping(value = "/roles/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Roles> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "roles/delete/{id}", method = {
			RequestMethod.GET, RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.OK)
	public void deleteAddress(@PathVariable("id") Long id) {
		Roles role = service.readById(id);
		if (role != null) {
			service.delete(role);
		}
	}

}
