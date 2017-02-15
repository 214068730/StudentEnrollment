package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.enrollment.domain.Lecturer;

public interface LecturerRepository extends CrudRepository<Lecturer,Long> {

}
