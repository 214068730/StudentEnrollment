package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.repository.CourseRepository;
import com.enrollment.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository repo;

	@Override
	public Course create(Course entity) {
		return repo.save(entity);
	}

	@Override
	public Course readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Course> readAll() {
		List<Course> courseList = new ArrayList<Course>();
		Iterable<Course> courses = repo.findAll();
		for (Course a : courses) {
			courseList.add(a);
		}
		return courseList;
	}

	@Override
	public Course update(Course entity) {
		if(entity == null)
			return null;
		else
			return repo.save(entity);
	}

	@Override
	public void delete(Course entity) {
		repo.delete(entity);
	}

	@Override
	public Course findByCourseName(String courseName) {
		return repo.findByCourseNameIgnoringCase(courseName);
	}

	@Override
	public Course findByCourseCode(String code) {
		return repo.findByCourseCodeIgnoringCase(code);
	}
}
