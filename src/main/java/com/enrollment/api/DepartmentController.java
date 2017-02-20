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

import com.enrollment.domain.Department;
import com.enrollment.service.Impl.DepartmentServiceImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl service;

	// find by id
	@RequestMapping(value = "department/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Department findById(@PathVariable Long id) {
		return service.readById(id);
	}

	// insert
	@RequestMapping(value = "/department/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Department create(@RequestBody Department department) {
		return service.create(department);
	}

	// update
	@RequestMapping(value = "/department/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Department department) {
		service.update(department);
	}

	// find All
	@RequestMapping(value = "/department/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Department> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "department/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
	@ResponseStatus(HttpStatus.OK)
	public void Department(@PathVariable("id") Long id) {
		Department deleteDepartment = service.readById(id);
		if (deleteDepartment != null) {
			service.delete(deleteDepartment);
		}
	}

}
