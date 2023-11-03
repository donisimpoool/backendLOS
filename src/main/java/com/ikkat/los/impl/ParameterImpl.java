package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ParameterEntity;
import com.ikkat.los.repo.ParameterRepo;
import com.ikkat.los.service.ParamaterService;

@Service
public class ParameterImpl implements ParamaterService{
	@Autowired
	private ParameterRepo repository;
	
	@Override
	public List<ParameterEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ParameterEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ParameterEntity update(String id, ParameterEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ParameterEntity create(ParameterEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

}
