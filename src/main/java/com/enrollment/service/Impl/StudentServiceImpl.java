package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Student;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Student create(Student entity) {
		return repo.save(entity);
	}

	@Override
	public Student readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Student> readAll() {

		List<Student> studentList = new ArrayList<Student>();
		Iterable<Student> students = repo.findAll();

		for (Student s : students) {
			studentList.add(s);
		}
		return studentList;
	}

	@Override
	public Student update(Student entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Student entity) {
		repo.delete(entity);
	}

	public Student findByStudentNumberAndStudentName(String studentNumber,
			String studentName) {
		Student student = repo.findByStudentNumberAndStudentName(studentNumber,
				studentName);
		return student;
	}

	public Student findByStudentNumber(String studentNumber) {
		Student student = repo.findByStudentNumber(studentNumber);
		return student;
	}
}
