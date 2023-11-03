package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationCollateralEntity;
import com.ikkat.los.entity.ApplicationCollateralVehicleEntity;
import com.ikkat.los.repo.ApplicationCollateralRepo;
import com.ikkat.los.repo.ApplicationCollateralVehicleRepo;
import com.ikkat.los.service.ApplicationCollateralService;

@Service
public class ApplicationCollateralImpl implements ApplicationCollateralService {
	@Autowired
	private ApplicationCollateralRepo repository;
	@Autowired
	private ApplicationCollateralVehicleRepo repositoryVehicle;
	
	@Override
	public List<ApplicationCollateralEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationCollateralEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationCollateralEntity update(String id, ApplicationCollateralEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationCollateralEntity create(ApplicationCollateralEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<ApplicationCollateralVehicleEntity> findAllCollateralVehicle() {
		// TODO Auto-generated method stub
		return repositoryVehicle.findAll();
	}

	@Override
	public Optional<ApplicationCollateralVehicleEntity> findCollateralVehicleById(String id) {
		// TODO Auto-generated method stub
		return repositoryVehicle.findById(id);
	}

	@Override
	public ApplicationCollateralVehicleEntity updateCollateralVehicle(String id,
			ApplicationCollateralVehicleEntity cs) {
		// TODO Auto-generated method stub
		return repositoryVehicle.save(cs);
	}

	@Override
	public ApplicationCollateralVehicleEntity createCollateralVehicle(ApplicationCollateralVehicleEntity cs) {
		// TODO Auto-generated method stub
		return repositoryVehicle.save(cs);
	}

	@Override
	public void deleteCollateralVehicle(String id) {
		// TODO Auto-generated method stub
		repositoryVehicle.deleteById(id);
		
	}

}
