package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enrollment.domain.Address;
import com.enrollment.domain.Student;
import com.enrollment.repository.AddressRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Student create(Student entity) {
		Iterable<Student> students = repo.findAll();
		boolean idExist = false;

		if (entity.getStudentID() == null) {
			for (Student stud : students) {
				if (entity.getStudentIdNumber().equals(stud.getStudentIdNumber())) {
					idExist = true;
					break;
				}
			}
		}
		if (idExist == true)
			return null;
		else {

			Address address = addressRepo.save(entity.getStudentAddress());
			entity.setStudentAddress(address);
			return repo.save(entity);
		}
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
		Iterable<Student> students = repo.findAll();
		boolean idExist = false;

		if (entity.getStudentID() != null) {
			for (Student stud : students) {
				if (entity.getStudentID() != stud.getStudentID()) {
					if (entity.getStudentIdNumber().equals(stud.getStudentIdNumber())) {
						idExist = true;
						break;
					}
				}
			}
		}
		if (idExist == true)
			return null;
		else {
			//
			addressRepo.save(entity.getStudentAddress()); // update address
			return repo.save(entity);
		}
	}

	@Override
	public void delete(Student entity) {
		repo.delete(entity);
	}

	public Student findByStudentNumberAndStudentName(String studentNumber,
			String studentName) {
		Student student = repo.findByStudentNumberAndStudentNameIgnoringCase(
				studentNumber, studentName);
		return student;
	}

	public Student findByStudentNumber(String studentNumber) {
		Student student = repo.findByStudentNumber(studentNumber);
		return student;
	}
}
