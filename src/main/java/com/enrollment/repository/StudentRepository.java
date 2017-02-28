package com.enrollment.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	//@Cacheable(value="LoginDetails",key="{#studentNumber,#studentName}")
	public Student findByStudentNumberAndStudentNameIgnoringCase(String studentNumber,String studentName);
	public Student findByStudentNumber(String studentNumber);
	
	@Override
	<S extends Student> S save(S Student);
}
