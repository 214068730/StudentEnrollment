package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.StudentCourse;

@Repository
public interface CourseRepository extends CrudRepository<StudentCourse,Long>  {

	public List<StudentCourse> findByStudentStudentID(Long studentID);
}
