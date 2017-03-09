package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusService extends Service<ProgressStatus, Long> {
	public ProgressStatus findByActiveAndStudentStudentID(int active,Long studentID,Long course);

}
