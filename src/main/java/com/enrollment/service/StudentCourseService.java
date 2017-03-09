package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.StudentCourse;
import com.enrollment.domain.Subject;

public interface StudentCourseService extends Service<StudentCourse,Long> {
	
	public List<StudentCourse> findCourseByStudentNumber(Long studentNumber);
	public List<StudentCourse> findByCourseCourseIDAndStudentStudentID(Long courseID,Long studentID);
	public boolean registerStudent(List<Subject> subjects,Long studentID,Long CourseID);
}
