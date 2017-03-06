package com.enrollment.service;

import com.enrollment.domain.Lecturer;

public interface LecturerService extends Service<Lecturer,Long> {
	public Lecturer findByLecturerNameAndLecturerSurname(String lecturerName,String LecturerSurname);

}
