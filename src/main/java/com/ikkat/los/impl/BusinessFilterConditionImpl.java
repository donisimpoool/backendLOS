package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.repo.BusinessFilterConditionRepo;
import com.ikkat.los.service.BusinessFilterConditionService;

@Service
public class BusinessFilterConditionImpl implements BusinessFilterConditionService {
	@Autowired
	private BusinessFilterConditionRepo repository;
	
	@Override
	public List<BusinessFilterConditionsEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<BusinessFilterConditionsEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public BusinessFilterConditionsEntity update(Long id, BusinessFilterConditionsEntity bf) {
		// TODO Auto-generated method stub
		return repository.save(bf);
	}

	@Override
	public BusinessFilterConditionsEntity create(BusinessFilterConditionsEntity bf) {
		// TODO Auto-generated method stub
		return repository.save(bf);
	}

	@Override
	public List<BusinessFilterConditionsEntity> create(List<BusinessFilterConditionsEntity> bfc) {
		// TODO Auto-generated method stub
		return repository.saveAll(bfc);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
