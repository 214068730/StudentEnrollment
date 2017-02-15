package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.enrollment.domain.Lecturer;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer,Long> {

}
