package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationBusinessEntity;
import com.ikkat.los.repo.ApplicationBusinessRepo;
import com.ikkat.los.service.ApplicationBusinessService;


@Service
public class ApplicationBusinessImpl implements ApplicationBusinessService{
	@Autowired
	private ApplicationBusinessRepo repository;
	
	@Override
	public List<ApplicationBusinessEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationBusinessEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationBusinessEntity update(String id, ApplicationBusinessEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationBusinessEntity create(ApplicationBusinessEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
