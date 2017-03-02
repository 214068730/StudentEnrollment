package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Department;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.service.ProgressStatusService;

@Service
public class ProgressStatusImpl implements ProgressStatusService {

	@Autowired
	ProgressStatusRepository repo;

	@Override
	public ProgressStatus create(ProgressStatus entity) {
		return repo.save(entity);
	}

	@Override
	public ProgressStatus readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<ProgressStatus> readAll() {
		List<ProgressStatus> progressList = new ArrayList<ProgressStatus>();
		Iterable<ProgressStatus> status = repo.findAll();
		for (ProgressStatus c : status) {
			progressList.add(c);
		}
		return progressList;
	}

	@Override
	public ProgressStatus update(ProgressStatus entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(ProgressStatus entity) {
		repo.delete(entity);
	}

	@Override
	public ProgressStatus findByStudentStudentIDAndActive(Long studentID,
			boolean active) {
		return repo.findByStudentStudentIDAndActive(studentID, active);
	}

}