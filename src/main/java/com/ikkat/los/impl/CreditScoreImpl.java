package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.CreditScoreEntity;
import com.ikkat.los.repo.creditScoreRepo;
import com.ikkat.los.service.CreditScoreService;

@Service
public class CreditScoreImpl implements CreditScoreService{
	@Autowired
	private creditScoreRepo repository;

	@Override
	public List<CreditScoreEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<CreditScoreEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public CreditScoreEntity update(Long id, CreditScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public CreditScoreEntity create(CreditScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
}
