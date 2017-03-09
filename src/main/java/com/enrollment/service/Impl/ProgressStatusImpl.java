package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Department;
import com.enrollment.domain.ProgressStatus;
import com.enrollment.domain.Student;
import com.enrollment.repository.ProgressStatusRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.ProgressStatusService;

@Service
public class ProgressStatusImpl implements ProgressStatusService {

	@Autowired
	ProgressStatusRepository repo;
	@Autowired
	StudentRepository studentRepo;
	private ProgressStatus status;

	@Override
	public ProgressStatus create(ProgressStatus entity) {
		return repo.save(entity);
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
	public ProgressStatus findByActiveAndStudentStudentID(int activate,Long studentID) {
		int active = 1;
		int completed = 0;
		if (studentID == null)
			return null;
		else {
			ProgressStatus activeStatus = repo.findByActiveAndStudentStudentID(activate, studentID);
			Student student = studentRepo.findOne(studentID);
			if(activeStatus == null){
				ProgressStatus deActiveStatus = repo.findByActiveAndStudentStudentID(0, studentID); // finding any record that is not active
				if(deActiveStatus == null)
					return repo.save(new ProgressStatus("1",active,completed,student));
				else
				{
					deActiveStatus.setActive(1);
					return repo.save(deActiveStatus);
				}	
			}
			else if(activeStatus.isCompleted() == 0)
				return null;
			else
			{
				int oldGrade = Integer.parseInt(status.getCurrentYear());
				int nextGrade = oldGrade + 1;
				activeStatus.setActive(0);
				repo.save(activeStatus);
				
				//return new grade
				ProgressStatus newGrade = new ProgressStatus(nextGrade + "",active, completed, student);
				return newGrade;
			}
				
		}
	}

}
