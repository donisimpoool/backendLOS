package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationBankEntity;
import com.ikkat.los.repo.ApplicationBankRepo;
import com.ikkat.los.service.ApplicationBankService;


@Service
public class ApplicationBankImpl implements ApplicationBankService{
	@Autowired
	private ApplicationBankRepo repository;
	
	@Override
	public List<ApplicationBankEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationBankEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationBankEntity update(String id, ApplicationBankEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationBankEntity create(ApplicationBankEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
