package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationAddressEntity;
import com.ikkat.los.repo.ApplicationAddressRepo;
import com.ikkat.los.service.ApplicationAddressService;

@Service
public class ApplicationAddressImpl implements ApplicationAddressService{
	@Autowired
	private ApplicationAddressRepo repository;
	
	@Override
	public List<ApplicationAddressEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationAddressEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationAddressEntity update(String id, ApplicationAddressEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationAddressEntity create(ApplicationAddressEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
