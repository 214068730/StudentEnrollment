package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Subject;
import com.enrollment.domain.SubjectCourse;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.SubjectCourseRepository;
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
	@Autowired
	private SubjectCourseRepository subjectCourseRepo;

	@Override
	public Subject create(Subject entity) {
		if (entity.getSubjectID() == null) {
			Subject subject = repo.findBySubjectCode(entity.getSubjectCode());
			if (subject == null)
				return repo.save(entity);
			else
				return null;
		} else
			return null;
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
		Subject subject = repo.findOne(entity.getSubjectID());
		if (subject == null)
			return null;
		else {
			String subjectCode = repo.findSubjectCode(entity.getSubjectID(),
					entity.getSubjectCode());
			if (subjectCode == null) {
				return repo.save(entity);
			} else
				return null;
		}
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
	public List<Subject> readAllSubjects(Long courseID, Long studentID) {
		List<Subject> subjectList = new ArrayList<Subject>();
		Course course = courseRepo.findOne(courseID);

		ProgressStatus status = statRepo.findByActiveAndStudentStudentID(1,studentID);
		List<Subject> subjects = subjectCourseRepo.findCourseID(course.getId());

		for (Subject subject : subjects) {
			if (subject.getYearCode() == Integer.parseInt(status.getCurrentYear())) {
				if (status.getCourse().getId() == course.getId()){
					subjectList.add(subject);
				}
			}
		}
		return subjectList;

	}
}
