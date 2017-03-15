package com.enrollment.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	//@Cacheable(value="LoginDetails",key="{#studentNumber,#studentName}")
	public Student findByStudentNumberAndStudentNameIgnoringCase(String studentNumber,String studentName);
	public Student findByStudentNumber(String studentNumber);
	public Student findByStudentIdNumber(String studentIdNumber);
	@Query("select s.studentIdNumber from Student s where s.studentID !=  :studentID and s.studentIdNumber = :studentIdNumber")
	public String findStudnetID(@Param("studentID") Long studentID, @Param("studentIdNumber") String studentIdNumber );
	
}
