package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Lecturer;
import com.enrollment.repository.LecturerRepository;
import com.enrollment.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	LecturerRepository repo;

	@Override
	public Lecturer create(Lecturer entity) {
		if (entity.getId() == null)
			return repo.save(entity);
		else
			return null;
	}

	@Override
	public Lecturer readById(Long id) {
		if (id == null)
			return null;
		else
			return repo.findOne(id);
	}

	@Override
	public List<Lecturer> readAll() {
		List<Lecturer> lectureList = new ArrayList<Lecturer>();
		Iterable<Lecturer> lecturers = repo.findAll();
		for (Lecturer c : lecturers) {
			lectureList.add(c);
		}
		return lectureList;
	}

	@Override
	public Lecturer update(Lecturer entity) {
		if (entity.getId() == null)
			return null;
		else
			return repo.save(entity);
	}

	@Override
	public void delete(Lecturer entity) {
		if (entity.getId() != null)
			repo.delete(entity);
	}

	@Override
	public Lecturer findByLecturerNameAndLecturerSurname(String lecturerName,
			String lecturerSurname) {
		if (lecturerName == null && lecturerSurname == null)
			return null;
		else
			return repo
					.findByLecturerNameIgnoringCaseAndLecturerSurnameIgnoringCase(
							lecturerName, lecturerSurname);
	}

}
