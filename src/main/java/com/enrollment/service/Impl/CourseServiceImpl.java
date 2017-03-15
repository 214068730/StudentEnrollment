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
		if (entity.getId() == null) {
			Course courseCode = repo.findByCourseCodeIgnoringCase(entity.getCourseCode());
			if (courseCode == null) {
				Course courseName = repo.findByCourseNameIgnoringCase(entity.getCourseName());
				if (courseName == null) 
					return repo.save(entity);
				else
					return null;
			} 
			else
				return null;
		} 
		else
			return null;
	}
		

	@Override
	public Course readById(Long id) {
		if (id == null)
			return null;
		else
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
		if (entity.getId() == null)
			return null;
		else {
			Course course = repo.findOne(entity.getId());
			if (course != null) {
				String courseCode = repo.findCourseCode(entity.getCourseCode(), entity.getId());
				if (courseCode == null) { //here
					String courseName = repo.findCourseName(entity.getCourseName(), entity.getId());
					if (courseName == null) {
						return repo.save(entity);
					}
					else
						return null;
				} 
				else
					return null;
			} 
			else
				return null;
		}
	}

	@Override
	public void delete(Course entity) {
		if (entity != null)
			repo.delete(entity);
	}

	@Override
	public Course findByCourseName(String courseName) {
		if (courseName == null)
			return null;
		else
			return repo.findByCourseNameIgnoringCase(courseName);
	}

	@Override
	public Course findByCourseCode(String code) {
		if (code == null)
			return null;
		else
			return repo.findByCourseCodeIgnoringCase(code);
	}
}
