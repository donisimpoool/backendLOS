package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.RegenciesEntity;
import com.ikkat.los.repo.RegenciesRepo;
import com.ikkat.los.service.RegenciesService;


@Service
public class RegenciesImpl implements RegenciesService{
	@Autowired
	private RegenciesRepo repository;

	@Override
	public List<RegenciesEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<RegenciesEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public RegenciesEntity update(String id, RegenciesEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public RegenciesEntity create(RegenciesEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<RegenciesEntity> GetListRegenciesNotEmptyIdSimpool() {
		// TODO Auto-generated method stub
		return repository.GetListRegenciesNotEmptyIdSimpool();
	}
	
	

}
