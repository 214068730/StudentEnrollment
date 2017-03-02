package com.enrollment.businessLogic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enrollment.domain.Course;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Student;
import com.enrollment.domain.StudentCourse;
import com.enrollment.domain.Subject;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.StudentCourseRepository;

public class StudentCourseLogic {
	@Autowired
	private StudentCourseRepository studentCourseRepo;
	@Autowired
	private ProgressStatusRepository progressRepo;

	public boolean registerStudent(Student student, List<Subject> subjects,Course course) {
		boolean active = true;
		boolean inserted = false;
		boolean completed = false;
		
		ProgressStatus currentGrade = progressRepo.findByStudentStudentIDAndActive(student.getStudentID(), active);
		if (currentGrade == null) {
			// inserting subjects into table
			registerSubjects(subjects, course, student);

			currentGrade.setCurrentYear("1");
			currentGrade.setStudent(student);
			currentGrade.setActive(true);
			currentGrade.setCompleted(true);
			ProgressStatus result = progressRepo.save(currentGrade);
			if (result != null) 
				inserted = true;
		} else
			if(currentGrade.isCompleted() != false){
			// inserting subjects into table
			int oldGrade = Integer.parseInt(currentGrade.getCurrentYear());
			int nextGrade = oldGrade + 1;
			registerSubjects(subjects, course, student);

			// deactivate old grade
			currentGrade.setActive(false);
			currentGrade.setCompleted(true);
			progressRepo.save(currentGrade);// updating

			// insert new grade
			ProgressStatus newGrade = new ProgressStatus(nextGrade + "",active,completed,student);
			ProgressStatus result = progressRepo.save(newGrade);// inserting
			if (result != null)
				inserted = true;
		}
		else
		{
			registerSubjects(subjects, course, student);
		}
		if (inserted == true)
			return true;
		 else
			return false;
	}

	private void registerSubjects(List<Subject> subjects, Course course,Student student) {
		for (Subject subs : subjects) {
			StudentCourse studentCourse = new StudentCourse(course, student,subs);
			studentCourseRepo.save(studentCourse);
		}
	}

}
