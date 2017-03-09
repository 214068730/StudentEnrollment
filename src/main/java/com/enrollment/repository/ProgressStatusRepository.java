package com.enrollment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusRepository  extends CrudRepository<ProgressStatus,Long>{
	
	public ProgressStatus findByActiveAndStudentStudentID(int active,Long studentID);
	public List<ProgressStatus>findByStudentStudentIDAndActive(Long studentID,int active);

}
