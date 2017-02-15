package com.enrollment.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.repository.CourseRepository;
import com.enrollment.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository repo;
	@Override
	public Course create(Course entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course readById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course update(Course entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Course entity) {
		// TODO Auto-generated method stub
		
	}

}
