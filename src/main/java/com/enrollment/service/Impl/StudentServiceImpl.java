package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		if(entity.getStudentID() == null)
		{
		    Student student = repo.findByStudentIdNumber(entity.getStudentIdNumber());
			if(student == null){
				addressRepo.save(entity.getStudentAddress()); // update address
     			return repo.save(entity);
			}
			else
				return null;
		}
		else
			return null;
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
		Student student = repo.findOne(entity.getStudentID());
		if(student == null)
			return null;
		else
		{
			String studentIdNumber = repo.findStudnetID(entity.getStudentID(),entity.getStudentIdNumber());
			if(studentIdNumber == null){
				addressRepo.save(entity.getStudentAddress()); // update address
     			return repo.save(entity);
			}
			else
				return null;
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
