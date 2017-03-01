package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Lecturer;
import com.enrollment.domain.Roles;
import com.enrollment.repository.RolesRepository;
import com.enrollment.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository repo;

	@Override
	public Roles create(Roles entity) {
		return repo.save(entity);
	}

	@Override
	public Roles readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Roles> readAll() {
		List<Roles> roles = new ArrayList<Roles>();
		Iterable<Roles> lecturers = repo.findAll();
		for (Roles c : lecturers) {
			roles.add(c);
		}
		return roles;
	}

	@Override
	public Roles update(Roles entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Roles entity) {
		repo.delete(entity);

	}

}
