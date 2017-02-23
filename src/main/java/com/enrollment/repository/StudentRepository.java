package com.enrollment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Course;
import com.enrollment.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	public Student findByStudentNumberAndStudentName(String studentNumber,String studentName);
}
