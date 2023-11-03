package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.FilterHeaderEntity;
import com.ikkat.los.repo.FilterHeaderRepo;
import com.ikkat.los.service.FilterHeaderService;

@Service
public class FilterHeaderImpl implements FilterHeaderService{
	@Autowired
	private FilterHeaderRepo repository;
	
	@Override
	public List<FilterHeaderEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<FilterHeaderEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public FilterHeaderEntity update(String id, FilterHeaderEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public FilterHeaderEntity create(FilterHeaderEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<FilterHeaderEntity> getlistByPage(int sizelimit) {
		// TODO Auto-generated method stub
		return repository.getlistByPage(sizelimit);
	}

}
