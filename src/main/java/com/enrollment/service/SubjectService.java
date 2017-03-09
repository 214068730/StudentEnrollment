package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.Subject;

public interface SubjectService extends Service<Subject, Long> {

	public Subject findBySubjectSubjectName(String subjectName);
	public Subject findBySubjectCode(String subjectCode);
	public List<Subject> readAllSubjects(Long courseID,Long StudentID);


}
