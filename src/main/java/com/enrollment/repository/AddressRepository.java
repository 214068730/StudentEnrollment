package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Address;
import com.enrollment.domain.StudentCourse;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

}
