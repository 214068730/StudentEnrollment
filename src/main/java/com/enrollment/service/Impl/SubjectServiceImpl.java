package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Subject;
import com.enrollment.repository.SubjectRepository;
import com.enrollment.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository repo;

	@Override
	public Subject create(Subject entity) {
		boolean flag = false;
		Iterable<Subject> subjects = repo.findAll();
		for (Subject sub : subjects) {
			if (entity.getSubjectCode().equals(sub.getSubjectCode())) {
				flag = true;
				break;
			}
		}
		if (flag == true)
			return null;
		else
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
		for (Subject s : subjects) {
			subjectList.add(s);
		}
		return subjectList;
	}

	@Override
	public Subject update(Subject entity) {
		boolean flag = false;
		Iterable<Subject> subjects = repo.findAll();
		for (Subject sub : subjects) {
			if (entity.getSubjectID() != sub.getSubjectID()) {
				if (entity.getSubjectCode().equals(sub.getSubjectCode())) {
					flag = true;
					break;
				}
			}
		}
		if (flag == true)
			return null;
		else
			return repo.save(entity);
	}

	@Override
	public void delete(Subject entity) {
		if (entity != null)
			repo.delete(entity);
	}

	@Override
	public Subject findBySubjectSubjectName(String subjectName) {
		if (subjectName.equals(null))
			return null;
		else
			return repo.findBySubjectName(subjectName);
	}

	@Override
	public Subject findBySubjectCode(String subjectCode) {
		if (subjectCode.equals(null))
			return null;
		else
			return repo.findBySubjectCode(subjectCode);
	}
}
