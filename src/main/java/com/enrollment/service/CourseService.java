package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.StudentCourse;

public interface CourseService extends Service<StudentCourse,Long> {
	
	public List<StudentCourse> findCourseByStudentNumber(Long studentNumber);

}
