package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Department;

@Repository
public interface DeparmentRepository extends CrudRepository<Department,Long>  {

}
