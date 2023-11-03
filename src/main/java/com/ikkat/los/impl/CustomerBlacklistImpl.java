package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.CustomerBlacklistEntity;
import com.ikkat.los.repo.CustomerBlacklistRepo;
import com.ikkat.los.service.CustomerBlacklistService;

@Service
public class CustomerBlacklistImpl implements CustomerBlacklistService{
	@Autowired
	private CustomerBlacklistRepo repository;
	
	@Override
	public List<CustomerBlacklistEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<CustomerBlacklistEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public CustomerBlacklistEntity update(Long id, CustomerBlacklistEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public CustomerBlacklistEntity create(CustomerBlacklistEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
