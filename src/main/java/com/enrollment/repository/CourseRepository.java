package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	public Course findByCourseName(String courseName);

}
