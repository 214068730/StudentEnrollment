package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.Course;

public interface CourseService extends Service<Course,Long> {
	
	public List<Course> findCourseByStudentNumber(Long studentNumber);

}
