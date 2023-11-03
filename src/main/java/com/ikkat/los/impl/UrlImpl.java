package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.UrlEntity;
import com.ikkat.los.repo.UrlRepo;
import com.ikkat.los.service.UrlService;

@Service
public class UrlImpl implements UrlService{
	@Autowired
	private UrlRepo repository;
	
	@Override
	public List<UrlEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<UrlEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public UrlEntity update(String id, UrlEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public UrlEntity create(UrlEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

}
