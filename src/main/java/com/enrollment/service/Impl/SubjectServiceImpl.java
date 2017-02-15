package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Subject;
import com.enrollment.repository.SubjectRepository;
import com.enrollment.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository repo;
	
	@Override
	public Subject create(Subject entity) {
		return repo.save(entity);
	}

	@Override
	public Subject readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Subject> readAll() {
		List<Subject> subjectList = new ArrayList<Subject>();
		Iterable<Subject> subjects = repo.findAll();
		
		for (Subject s : subjects){
			subjectList.add(s);
		}			
		return subjectList;
	}

	@Override
	public Subject update(Subject entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Subject entity) {
		repo.delete(entity);
	}

}
