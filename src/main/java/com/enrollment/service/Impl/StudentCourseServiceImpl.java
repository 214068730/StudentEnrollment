package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Student;
import com.enrollment.domain.StudentCourse;
import com.enrollment.domain.Subject;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.StudentCourseRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	StudentCourseRepository repo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	ProgressStatusRepository statusRepo;
	
	

	@Override
	public StudentCourse create(StudentCourse entity) {
		return repo.save(entity);
	}

	@Override
	public StudentCourse readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<StudentCourse> readAll() {
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		Iterable<StudentCourse> courses = repo.findAll();
		for (StudentCourse c : courses) {
			courseList.add(c);
		}
		return courseList;
	}

	@Override
	public StudentCourse update(StudentCourse entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(StudentCourse entity) {
		repo.delete(entity);

	}

	@Override
	public List<StudentCourse> findCourseByStudentNumber(Long studentNumber) {
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		Iterable<StudentCourse> courses = repo
				.findByStudentStudentID(studentNumber);
		for (StudentCourse c : courses) {
			courseList.add(c);
		}
		return courseList;

	}

	@Override
	public List<StudentCourse> findByCourseCourseIDAndStudentStudentID(
			Long courseID, Long studentID) {
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		Iterable<StudentCourse> courses = repo.findByCourseCourseIDAndStudentStudentID(courseID,studentID);
		for (StudentCourse c : courses) {
			courseList.add(c);
		}
		return courseList;

	}

	@Override
	public boolean registerStudent(List<Subject> subjects, Long studentID,Long courseID) {
		Boolean created = false;
		int active = 1;
		if(studentID == null || courseID == null || subjects.isEmpty() )
			return false;
		else
		{
			Student student = studentRepo.findOne(studentID);
			if(student == null)
				return false;
			else
			{
				Course course = courseRepo.findOne(courseID);
				if(course == null)
					return false;
				else
				{
					ProgressStatus status = statusRepo.findByActiveAndStudentStudentID(active, student.getStudentID());
					for(Subject subject : subjects)
					{
						created = false;
						repo.save(new StudentCourse(course,student,subject));
						created = true;
					}
					if(created == false)
						return false;
					else
						return true;
				}
			}
		}
	}
}
