package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.applicationPersonelEntity;
import com.ikkat.los.repo.applicationPersoneRepo;
import com.ikkat.los.service.ApplicationPersonelService;

@Service
public class ApplicationPersonelImpl implements ApplicationPersonelService{
	@Autowired
	private applicationPersoneRepo repository;

	@Override
	public List<applicationPersonelEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<applicationPersonelEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public applicationPersonelEntity update(String id, applicationPersonelEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public applicationPersonelEntity create(applicationPersonelEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
