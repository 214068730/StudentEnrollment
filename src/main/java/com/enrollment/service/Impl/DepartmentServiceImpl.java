package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Department;
import com.enrollment.repository.DepartmentRepository;
import com.enrollment.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repo;

	@Override
	public Department create(Department entity) {
		if(entity.getDepartmentID() == null){
			Department department = repo.findByDepartmentName(entity.getDepartmentName());
			if(department == null){
				return repo.save(entity);
			}
			else
				return null;
		}
		else
			return null;
	}

	@Override
	public Department readById(Long id) {
		if (id == null)
			return null;
		else
			return repo.findOne(id);
	}

	@Override
	public List<Department> readAll() {
		List<Department> departmentList = new ArrayList<Department>();
		Iterable<Department> departments = repo.findAll();
		for (Department c : departments) {
			departmentList.add(c);
		}
		return departmentList;
	}

	@Override
	public Department update(Department entity) {
		if (entity.getDepartmentID() == null)
			return null;
		else {
			String department = repo.findDepartName(entity.getDepartmentID(), entity.getDepartmentName());
			if(department == null)
				return repo.save(entity);
			else
				return null;
		}
	}

	@Override
	public void delete(Department entity) {
		if (entity != null)
			repo.delete(entity);
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		if (departmentName == null)
			return null;
		else
			return repo.findByDepartmentName(departmentName);
	}

}
