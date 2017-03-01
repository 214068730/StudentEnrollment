package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusRepository  extends CrudRepository<ProgressStatus,Long>{
	
	public ProgressStatus findByStudentStudentIDAndActive(Long studentID,boolean active);

}
