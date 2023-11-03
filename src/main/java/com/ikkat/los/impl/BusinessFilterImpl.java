package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.entity.BusinessFilterEntity;
import com.ikkat.los.repo.BusinessFilterRepo;
import com.ikkat.los.service.BusinessFilterService;

@Service
public class BusinessFilterImpl implements BusinessFilterService{
	@Autowired
	private BusinessFilterRepo repository;
	
	@Override
	public List<BusinessFilterEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<BusinessFilterEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public BusinessFilterEntity update(Long id, BusinessFilterEntity bf) {
		// TODO Auto-generated method stub
		return repository.save(bf);
	}

	@Override
	public BusinessFilterEntity create(BusinessFilterEntity bf) {
		// TODO Auto-generated method stub
		return repository.save(bf);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
