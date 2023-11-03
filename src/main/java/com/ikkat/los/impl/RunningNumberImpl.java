package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.RunningNumberEntity;
import com.ikkat.los.repo.RunningNumberRepo;
import com.ikkat.los.service.RunningNumberService;

@Service
public class RunningNumberImpl implements RunningNumberService{
	@Autowired
	private RunningNumberRepo repository;

	@Override
	public List<RunningNumberEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<RunningNumberEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public RunningNumberEntity update(long id, RunningNumberEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public RunningNumberEntity create(RunningNumberEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public RunningNumberEntity getlistRunningNumberEntity(String paramater) {
		// TODO Auto-generated method stub
		return repository.getlistRunningNumberEntity(paramater);
	}
}
