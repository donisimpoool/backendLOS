package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.DistrictEntity;
import com.ikkat.los.repo.DistrictRepo;
import com.ikkat.los.service.DistrictService;

@Service
public class DistrictImpl implements DistrictService {
	@Autowired
	private DistrictRepo repository;

	@Override
	public List<DistrictEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<DistrictEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public DistrictEntity update(String id, DistrictEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public DistrictEntity create(DistrictEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
	

}
