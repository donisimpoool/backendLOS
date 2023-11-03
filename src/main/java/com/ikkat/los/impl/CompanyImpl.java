package com.ikkat.los.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.CompanyEntity;
import com.ikkat.los.repo.CompanyRepo;
import com.ikkat.los.service.CompanyService;

@Service
public class CompanyImpl implements CompanyService{
	@Autowired
	private CompanyRepo repository;
	
	@Override
	public Optional<CompanyEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
