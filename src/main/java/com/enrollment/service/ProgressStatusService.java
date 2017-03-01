package com.enrollment.service;

import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusService extends Service<ProgressStatus, Long> {
	public ProgressStatus findByStudentStudentIDAndActive(Long studentID,
			boolean active);

}
