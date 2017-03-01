package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.StudentCourse;
import com.enrollment.repository.CourseRepository;
import com.enrollment.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository repo;

	@Override
	public StudentCourse create(StudentCourse entity) {
		return repo.save(entity);
	}

	@Override
	public StudentCourse readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<StudentCourse> readAll() {
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		Iterable<StudentCourse> courses = repo.findAll();
		for (StudentCourse c : courses) {
			courseList.add(c);
		}
		return courseList;
	}

	@Override
	public StudentCourse update(StudentCourse entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(StudentCourse entity) {
		repo.delete(entity);

	}
	
	@Override
	public List<StudentCourse> findCourseByStudentNumber(Long studentNumber){
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		Iterable<StudentCourse> courses = repo.findByStudentStudentID(studentNumber);
		for (StudentCourse c : courses) {
			courseList.add(c);
		}
		return courseList;
		
	} 
}
