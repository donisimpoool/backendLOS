package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.entity.ProvinceEntity;
import com.ikkat.los.repo.ProvinceRepo;
import com.ikkat.los.service.ProvinceService;


@Service
public class ProvinceImpl implements ProvinceService{
	@Autowired
	private ProvinceRepo repository;

	@Override
	public List<ProvinceEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ProvinceEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ProvinceEntity update(String id, ProvinceEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ProvinceEntity create(ProvinceEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<ProvinceEntity> GetListProvinceNotEmptyIdSimpool() {
		// TODO Auto-generated method stub
		return repository.GetListProvinceNotEmptyIdSimpool();
	}
	
	

}
