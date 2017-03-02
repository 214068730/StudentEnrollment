package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.enrollment.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
