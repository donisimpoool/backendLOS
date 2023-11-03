package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.repo.applicationRepo;
import com.ikkat.los.service.applicationService;


@Service
public class applicationImpl implements applicationService{
	@Autowired
	private applicationRepo repository;
	
	
	@Override
	public List<applicationEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<applicationEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public applicationEntity update(String id, applicationEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public applicationEntity create(applicationEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<applicationEntity> findByStatus(String status) {
		// TODO Auto-generated method stub
		return repository.findbystatus(status);
	}

	@Override
	public List<applicationEntity> findbystatusperpage(String status, int sizelimit) {
		// TODO Auto-generated method stub
		return repository.findbystatusperpage(status, sizelimit);
	}

	@Override
	public List<applicationEntity> findbyIsDraft(String status, String isdraft) {
		// TODO Auto-generated method stub
		return repository.findbyIsDraft(status, isdraft);
	}

	@Override
	public List<applicationEntity> findbyOnlyIsDraft(String isdraft) {
		// TODO Auto-generated method stub
		return repository.findbyOnlyIsDraft(isdraft);
	}

}
