package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.ListDocumentEntity;
import com.ikkat.los.repo.ListDocumentRepo;
import com.ikkat.los.service.ListDocumentService;


@Service
public class ListDocumentImpl implements ListDocumentService{
	@Autowired
	private ListDocumentRepo repository;
	
	@Override
	public List<ListDocumentEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ListDocumentEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public ListDocumentEntity update(long id, ListDocumentEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public ListDocumentEntity create(ListDocumentEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<ListDocumentEntity> listdocumentbyappid(String applicationid) {
		// TODO Auto-generated method stub
		return repository.listdocumentbyappid(applicationid);
	}

}
