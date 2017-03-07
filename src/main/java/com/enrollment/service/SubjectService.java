package com.enrollment.service;

import com.enrollment.domain.Subject;

public interface SubjectService extends Service<Subject, Long> {

	public Subject findBySubjectSubjectName(String subjectName);
	public Subject findBySubjectCode(String subjectCode);


}
