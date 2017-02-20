package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long>  {

//	@Query(value = "SELECT  c FROM Course c  WHERE c.id = :studentNumber")
//	public List<Course> findCourseByStudentId(@Param("studentNumber")Long studentNumber);
}
