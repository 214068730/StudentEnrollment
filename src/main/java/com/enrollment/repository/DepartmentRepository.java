package com.enrollment.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long>  {
	public Department findByDepartmentName(String departmentName);
	
	@Query("select d.departmentName from Department d where d.departmentID !=:id and d.departmentName = :departmentName")
	public String findDepartName(@Param("id") Long id,@Param("departmentName")String departmentName);

}
