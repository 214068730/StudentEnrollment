package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.enrollment.domain.ProgressStatus;

public interface ProgressStatusRepository  extends CrudRepository<ProgressStatus,Long>{
	
	public ProgressStatus findByActiveAndStudentStudentID(String active,Long studentID);
	
	

	public List<ProgressStatus>findByStudentStudentIDAndActive(Long studentID,String active);
	
	
	@Query("select s from ProgressStatus s where student.studentID = :studentID and s.active = :active and s.completed = :completed ")
	public ProgressStatus findLastRegisteredAccount(@Param("studentID")Long studentID,@Param("active")String active,@Param("completed")String completed);
	

}
