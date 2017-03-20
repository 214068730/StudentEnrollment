package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Course;
import com.enrollment.domain.Department;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Student;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.ProgressStatusService;

@Service
public class ProgressStatusImpl implements ProgressStatusService {

	@Autowired
	ProgressStatusRepository repo;
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	CourseRepository courseRepo;
	ProgressStatus status = new ProgressStatus();

	@Override
	public ProgressStatus create(ProgressStatus entity) {
		if(entity.getId() == null)
			return repo.save(entity);
		else
			return null;
	}

	@Override
	public ProgressStatus readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<ProgressStatus> readAll() {
		List<ProgressStatus> progressList = new ArrayList<ProgressStatus>();
		Iterable<ProgressStatus> status = repo.findAll();
		for (ProgressStatus c : status) {
			progressList.add(c);
		}
		return progressList;
	}

	@Override
	public ProgressStatus update(ProgressStatus entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(ProgressStatus entity) {
		repo.delete(entity);
	}

	@Override
	public ProgressStatus findByActiveAndStudentStudentID(String activate,Long studentID, Long course) {
		String active = "1";
		String completed = "0";
		if (studentID == null)
			return null;
		else {
			ProgressStatus activeStatus = repo.findByActiveAndStudentStudentID(activate, studentID);
			Student student = studentRepo.findOne(studentID);
			Course resultCourse = courseRepo.findOne(course);
			
			if (activeStatus == null) {
				boolean exist = false;
				List<ProgressStatus> deActiveStatus = repo.findByStudentStudentIDAndActive(studentID,"0"); // finding any record that is not active
				for (ProgressStatus stat : deActiveStatus) {
					if (resultCourse.getId() == stat.getCourse().getId()) {
						if(stat.getActive().equals("0")&& stat.getCompleted().equals("0")){
							status = stat;
							exist = true;
							break;
						}
					}
				}
				if (exist == true) {
					status.setActive("1");
					return repo.save(status);
				} 
				else
					return repo.save(new ProgressStatus("1", active, completed,student, resultCourse));
			}
			else if (activeStatus.getCompleted().equals("0"))
				return null;
			else {
				int oldGrade = Integer.parseInt(activeStatus.getCurrentYear());
				int nextGrade = oldGrade + 1;
				activeStatus.setActive("0");
				repo.save(activeStatus); //previous year of studies is no longer active

				// return new grade
				ProgressStatus newGrade = repo.save(new ProgressStatus(Integer.toString(nextGrade),active, completed, student, resultCourse));
				return newGrade;
			}

		}
	}
	
	@Override
	public ProgressStatus findActiveStudent(Long studentID,String active){
		return repo.findByActiveAndStudentStudentID(active, studentID);
	}
}
