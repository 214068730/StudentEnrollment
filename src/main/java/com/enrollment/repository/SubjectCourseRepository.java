package com.enrollment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.SubjectCourse;

@Repository
public interface SubjectCourseRepository extends CrudRepository<SubjectCourse, Long> {
	public List<SubjectCourse> findByCourseCourseID(Long courseID);

}
