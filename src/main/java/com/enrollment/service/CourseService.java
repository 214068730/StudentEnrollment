package com.enrollment.service;

import com.enrollment.domain.Course;

public interface CourseService extends Service<Course, Long> {
	public Course findByCourseName(String courseName);
	public Course findByCourseCode(String code);

}
