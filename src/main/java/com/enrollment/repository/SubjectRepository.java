package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
	public Subject findBySubjectName(String subjectName);

}
