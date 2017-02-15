package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
