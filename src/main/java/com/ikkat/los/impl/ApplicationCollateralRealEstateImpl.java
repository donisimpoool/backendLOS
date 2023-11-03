package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationCollateralRealEstateEntity;
import com.ikkat.los.repo.ApplicationCollateralRealEstateRepo;
import com.ikkat.los.service.ApplicationCollateralRealEstateService;

@Service
public class ApplicationCollateralRealEstateImpl implements ApplicationCollateralRealEstateService{
	@Autowired
	private ApplicationCollateralRealEstateRepo repository;
	
	@Override
	public List<ApplicationCollateralRealEstateEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationCollateralRealEstateEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationCollateralRealEstateEntity update(String id, ApplicationCollateralRealEstateEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationCollateralRealEstateEntity create(ApplicationCollateralRealEstateEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
