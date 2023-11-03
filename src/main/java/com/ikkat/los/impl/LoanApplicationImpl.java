package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.LoanapplicationEntity;
import com.ikkat.los.repo.CustomerRepo;
import com.ikkat.los.repo.LoanApplicationRepo;
import com.ikkat.los.service.LoanApplicationService;

@Service
public class LoanApplicationImpl implements LoanApplicationService{
	@Autowired
	private LoanApplicationRepo repository;
	
	@Override
	public List<LoanapplicationEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<LoanapplicationEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public LoanapplicationEntity update(String id, LoanapplicationEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public LoanapplicationEntity create(LoanapplicationEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
