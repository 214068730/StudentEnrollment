package com.enrollment.service;

import java.util.List;

import com.enrollment.domain.StudentCourse;

public interface Service<E, ID> {
	E create(E entity);

	E readById(ID id);

	List<E> readAll();

	E update(E entity);

	void delete(E entity);

}
