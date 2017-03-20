package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusService extends Service<ProgressStatus, Long> {
	public ProgressStatus findByActiveAndStudentStudentID(String active,Long studentID,Long course);
	public ProgressStatus findActiveStudent(Long studentID,String active);

}
