package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Department;
import com.enrollment.repository.DeparmentRepository;
import com.enrollment.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DeparmentRepository repo;
	
	

	@Override
	public Department create(Department entity) {
		return repo.save(entity);
	}

	@Override
	public Department readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Department> readAll() {
		List<Department> departmentList = new ArrayList<Department>();
        Iterable<Department> departments = repo.findAll();
        for (Department c : departments){
        	departmentList.add(c);
        }
        return departmentList;
	}

	@Override
	public Department update(Department entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Department entity) {
		repo.delete(entity);
	}

}
