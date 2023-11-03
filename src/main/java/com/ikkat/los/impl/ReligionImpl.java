package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ReligionEntity;
import com.ikkat.los.repo.ReligionRepo;
import com.ikkat.los.service.ReligionService;

@Service
public class ReligionImpl implements ReligionService{
	@Autowired
	private ReligionRepo repository;
	
	@Override
	public List<ReligionEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ReligionEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ReligionEntity update(String id, ReligionEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ReligionEntity create(ReligionEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
