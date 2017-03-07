package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Address;
import com.enrollment.domain.SubjectCourse;
import com.enrollment.repository.SubjectCourseRepository;
import com.enrollment.service.SubjectCourseService;

@Service
public class SubjectCourseServiceImpl implements SubjectCourseService {

	@Autowired
	SubjectCourseRepository repo;

	@Override
	public SubjectCourse create(SubjectCourse entity) {
		Iterable<SubjectCourse> subjectCourses = repo.findAll();
		boolean exist = false;
		for (SubjectCourse subCourse : subjectCourses) {
			if (entity.getCourse().getId() == subCourse.getCourse().getId()
					&& entity.getSubject().getSubjectID() == subCourse
							.getSubject().getSubjectID()) {
				exist = true;
				break;
			}

		}
		if (exist == true)
			return null;
		else
			return repo.save(entity);
	}

	@Override
	public SubjectCourse readById(Long id) {
		if (id == null)
			return null;
		else

			return repo.findOne(id);
	}

	@Override
	public List<SubjectCourse> readAll() {
		List<SubjectCourse> subjectCourseList = new ArrayList<SubjectCourse>();
		Iterable<SubjectCourse> subjectCourses = repo.findAll();
		for (SubjectCourse a : subjectCourses) {
			subjectCourseList.add(a);
		}
		return subjectCourseList;
	}

	@Override
	public SubjectCourse update(SubjectCourse entity) {
		if (entity == null)
			return null;
		else
			return repo.save(entity);
	}

	@Override
	public void delete(SubjectCourse entity) {
		if (entity != null)
			repo.delete(entity);
	}

}
