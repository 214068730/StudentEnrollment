package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
	public Subject findBySubjectName(String subjectName);
	public Subject findBySubjectCode(String subjectCode);
	public List<Subject>findByYearLevel(int yearLevel);
	
	@Query("select s.subjectCode from Subject s where s.subjectCode = :subjectCode and s.subjectID != :id")
	public String findSubjectCode(@Param("id")Long id,@Param("subjectCode")String subjectCode);
	

}
