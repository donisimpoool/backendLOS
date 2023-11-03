package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationCollateralDepositEntity;
import com.ikkat.los.repo.ApplicationCollateralDepositRepo;
import com.ikkat.los.repo.ApplicationCollateralRepo;
import com.ikkat.los.service.ApplicationCollateralDepositService;

@Service
public class ApplicationCollateralDepositImpl implements ApplicationCollateralDepositService{
	@Autowired
	private ApplicationCollateralDepositRepo repository;
	
	@Override
	public List<ApplicationCollateralDepositEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationCollateralDepositEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationCollateralDepositEntity update(String id, ApplicationCollateralDepositEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationCollateralDepositEntity create(ApplicationCollateralDepositEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
