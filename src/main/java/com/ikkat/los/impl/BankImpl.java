package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.BankEntity;
import com.ikkat.los.repo.BankRepo;
import com.ikkat.los.service.BankService;

@Service
public class BankImpl implements BankService{
	
	@Autowired
	private BankRepo repository;
	
	@Override
	public List<BankEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<BankEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public BankEntity update(String id, BankEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public BankEntity create(BankEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
