package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ApplicationDocumentEntity;
import com.ikkat.los.repo.ApplicationDocumentRepo;
import com.ikkat.los.service.ApplicationDocumentService;

@Service
public class ApplicationDocumentImpl implements ApplicationDocumentService{
	@Autowired
	private ApplicationDocumentRepo repository;
	
	@Override
	public List<ApplicationDocumentEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ApplicationDocumentEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ApplicationDocumentEntity update(String id, ApplicationDocumentEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ApplicationDocumentEntity create(ApplicationDocumentEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}

}
