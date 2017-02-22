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
import com.enrollment.service.Impl.AddressServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class AddressController {

	@Autowired
	private AddressServiceImpl service;

	// find by id
	@RequestMapping(value = "address/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Address findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/address/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Address create(@RequestBody Address address) {
		return service.create(address);
	}

	// update
	@RequestMapping(value = "/address/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Address address) {
		service.update(address);
	}

	// find All
	@RequestMapping(value = "/address/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Address> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "address/delete/{id}", method = { RequestMethod.GET,RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.OK)
	public void deleteAddress(@PathVariable("id") Long id) {
		Address address = service.readById(id);
		if (address != null) {
			service.delete(address);
		}
	}
}
