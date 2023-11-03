package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationScoreEntity;
import com.ikkat.los.repo.ApplicationScoreRepo;
import com.ikkat.los.service.ApplicationScoreService;

@Service
public class ApplicationScoreImpl implements ApplicationScoreService{
	@Autowired
	private ApplicationScoreRepo repository;
	
	@Override
	public List<ApplicationScoreEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationScoreEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationScoreEntity update(String id, ApplicationScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationScoreEntity create(ApplicationScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
