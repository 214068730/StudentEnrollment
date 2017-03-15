package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Subject;
import com.enrollment.domain.SubjectCourse;

@Repository
public interface SubjectCourseRepository extends CrudRepository<SubjectCourse, Long> {
	public List<SubjectCourse> findByCourseCourseID(Long courseID);
	public SubjectCourse findByCourseCourseIDAndSubjectSubjectID(Long courseID,Long subjectID);
	
	@Query("select s.subject from SubjectCourse s where s.course.courseID = :id ")
	public List<Subject> findCourseID(@Param("id") Long id);
}
