package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Subject;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.SubjectRepository;
import com.enrollment.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository repo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ProgressStatusRepository statRepo;
	
	

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

	@Override
	public List<Subject> readAllSubjects(Long courseID,Long studentID) {
		List<Subject> subjectList = new ArrayList<Subject>();
		Course course = courseRepo.findOne(courseID);
		ProgressStatus status = statRepo.findByActiveAndStudentStudentID(1, studentID);
		List<Subject> subjects = readAll();
		if(status.getCourse().getId() == course.getId()){
			for(Subject subject : subjects){
				if(subject.getYearCode() == Integer.parseInt(status.getCurrentYear())){
					subjectList.add(subject);
				}
			}
			return subjectList;
			
		}
		else
		{
			for(Subject subject : subjects){
				if(subject.getYearCode() == 1){
					subjectList.add(subject);
				}
			}
			return subjectList;
		}
		
	}
}
