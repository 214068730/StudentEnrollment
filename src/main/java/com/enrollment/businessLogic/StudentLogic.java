package com.enrollment.businessLogic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.enrollment.domain.Student;
import com.enrollment.repository.StudentRepository;

public class StudentLogic {

	@Autowired
	private StudentRepository repo;

	public Student createStudent(Student entity) {
		Iterable<Student> students = repo.findAll();
		boolean created = false;

		if (entity.getStudentID() != null) {
			for (Student stud : students) {
				if (entity.getStudentIdNumber() == stud.getStudentIdNumber()) {
					created = true;
					break;
				}
			}
		}
		if (created == true)
			return null;
		else
		{
			return repo.save(entity);
		}

	}
	
	
}
