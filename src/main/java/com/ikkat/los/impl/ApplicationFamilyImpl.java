package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationFamilyEntity;
import com.ikkat.los.repo.ApplicationFamilyRepo;
import com.ikkat.los.service.ApplicationFamilyService;



@Service
public class ApplicationFamilyImpl implements ApplicationFamilyService{
	@Autowired
	private ApplicationFamilyRepo repository;
	
	@Override
	public List<ApplicationFamilyEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationFamilyEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationFamilyEntity update(String id, ApplicationFamilyEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationFamilyEntity create(ApplicationFamilyEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
