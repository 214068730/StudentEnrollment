package com.enrollment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.domain.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Long> {

}
