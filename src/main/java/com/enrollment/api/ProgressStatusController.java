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

import com.enrollment.domain.Lecturer;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.service.Impl.ProgressStatusImpl;

@RestController
@RequestMapping(value = "/enrollment")
public class ProgressStatusController {

	@Autowired
	ProgressStatusImpl service;

	// find by id
	@RequestMapping(value = "progress/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProgressStatus findById(@PathVariable Long id) {
		return service.readById(id);
	}
	
	
	//find student enrollment status
	@RequestMapping(value = "progress/findActive/{studentID}/{active}", method = RequestMethod.GET)
	@ResponseBody
	public ProgressStatus findActive(@PathVariable Long studentID,@PathVariable int active) {
		return service.findActiveStudent(studentID, active);
	}

	// find by grade
	@RequestMapping(value = "/progress/grade/{active}/{studentID}/{courseID}", method = RequestMethod.GET)
	@ResponseBody
	public ProgressStatus findByGradeStatus(@PathVariable Long studentID, @PathVariable int active,@PathVariable Long courseID) {
		return service.findByActiveAndStudentStudentID(active, studentID,courseID);
	}

	// insert
	@RequestMapping(value = "/progress/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ProgressStatus create(@RequestBody ProgressStatus progressStatus) {
		return service.create(progressStatus);
	}

	// update
	@RequestMapping(value = "/progress/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody ProgressStatus progreeStatus) {
		service.update(progreeStatus);
	}

	// find All
	@RequestMapping(value = "/progress/findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<ProgressStatus> findAll() {
		return service.readAll();
	}

	// delete
	@RequestMapping(value = "progress/delete/{id}", method = {
			RequestMethod.GET, RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.OK)
	public void deleteProgress(@PathVariable("id") Long id) {
		ProgressStatus deleteProgressStatus = service.readById(id);
		if (deleteProgressStatus != null) {
			service.delete(deleteProgressStatus);
		}
	}

}
