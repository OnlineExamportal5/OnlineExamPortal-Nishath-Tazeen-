package com.examportal2.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal2.Model.Address;
import com.examportal2.Repository.AddressRepo;

@Service

@Transactional
public class AddressService {
	@Autowired
	AddressRepo repo;

	public Address addAddress(Address a) {
		return repo.save(a);
	}

}
