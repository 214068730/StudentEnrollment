package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.SubjectCourse;

@Repository
public interface SubjectCourseRepository extends CrudRepository<SubjectCourse, Long> {

}
