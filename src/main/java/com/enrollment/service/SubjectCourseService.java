package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.SubjectCourse;

public interface SubjectCourseService extends Service<SubjectCourse, Long> {
	public List<SubjectCourse> findByCourseCourseID(Long courseID);

}
