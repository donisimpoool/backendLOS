package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.LogEntity;
import com.ikkat.los.repo.logRepo;
import com.ikkat.los.service.LogService;

@Service
public class LogImpl implements LogService{
	@Autowired
	private logRepo repository;
	
	@Override
	public List<LogEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<LogEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public LogEntity update(long id, LogEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public LogEntity create(LogEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
