package com.enrollment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
	public Course findByCourseCodeIgnoringCase(String code);
	public Course findByCourseNameIgnoringCase(String courseName);
	
	@Query("select c.courseCode from Course c where c.courseID !=  :id and c.courseCode = :code")
	public String findCourseCode(@Param("code")String code,@Param("id")Long id);
	
	@Query("select c.courseName from Course c where c.courseID !=  :id and c.courseName = :name")
	public String findCourseName(@Param("name")String name,@Param("id")Long id);

}
