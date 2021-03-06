package com.enrollment.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.domain.Address;
import com.enrollment.domain.StudentCourse;
import com.enrollment.repository.AddressRepository;
import com.enrollment.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository repo;

	@Override
	public Address create(Address entity) {
		return repo.save(entity);
	}

	@Override
	public Address readById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Address> readAll() {
		List<Address> addressList = new ArrayList<Address>();
		Iterable<Address> addresses = repo.findAll();
		for (Address a : addresses) {
			addressList.add(a);
		}
		return addressList;
	}

	@Override
	public Address update(Address entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Address entity) {
		if (entity != null)
			repo.delete(entity);

	}

}
