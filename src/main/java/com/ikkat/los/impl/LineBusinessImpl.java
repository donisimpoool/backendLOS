package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.LineBusinessEntity;
import com.ikkat.los.repo.LineBusinessRepo;
import com.ikkat.los.service.LineBusinessService;

@Service
public class LineBusinessImpl implements LineBusinessService{
	@Autowired
	private LineBusinessRepo repository;
	
	@Override
	public List<LineBusinessEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<LineBusinessEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public LineBusinessEntity update(String id, LineBusinessEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public LineBusinessEntity create(LineBusinessEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
