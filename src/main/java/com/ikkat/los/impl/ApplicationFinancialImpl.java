package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationFinancialEntity;
import com.ikkat.los.repo.ApplicationFinancialRepo;
import com.ikkat.los.service.ApplicationFinancialService;


@Service
public class ApplicationFinancialImpl implements ApplicationFinancialService{
	@Autowired
	private ApplicationFinancialRepo repository;
	
	@Override
	public List<ApplicationFinancialEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationFinancialEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationFinancialEntity update(String id, ApplicationFinancialEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationFinancialEntity create(ApplicationFinancialEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
