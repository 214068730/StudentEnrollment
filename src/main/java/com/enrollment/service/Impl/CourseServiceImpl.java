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
		boolean exist = false;
		Iterable<Course> courses = repo.findAll();
		for (Course course : courses) {
			if (entity.getCourseCode().equals(course.getCourseCode())) {
				exist = true;
				break;
			}
		}
		if (exist == true)
			return null;
		else
			return repo.save(entity);
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
			boolean exist = false;
			Iterable<Course> courses = repo.findAll();
			for (Course course : courses) {
				if (entity.getId() != course.getId()) {
					if (entity.getCourseCode().equals(course.getCourseCode())) {
						exist = true;
						break;
					}
				}
			}
			if (exist == true)
				return null;
			else
				return repo.save(entity);

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
