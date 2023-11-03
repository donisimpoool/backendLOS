package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ProvinceSimpoolEntity;
import com.ikkat.los.repo.ProvinceSimpoolRepo;
import com.ikkat.los.service.ProvinceSimpoolService;

@Service
public class ProvinceSimpoolImpl implements ProvinceSimpoolService {
	@Autowired
	private ProvinceSimpoolRepo repository;
	
	@Override
	public List<ProvinceSimpoolEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ProvinceSimpoolEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ProvinceSimpoolEntity update(String id, ProvinceSimpoolEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ProvinceSimpoolEntity create(ProvinceSimpoolEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub\
		repository.deleteById(id);
		
	}

}
