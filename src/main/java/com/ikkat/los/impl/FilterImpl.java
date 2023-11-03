package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.FilterEntity;
import com.ikkat.los.repo.FilterRepo;
import com.ikkat.los.repo.LoanApplicationRepo;
import com.ikkat.los.service.FilterService;


@Service
public class FilterImpl implements FilterService{
	@Autowired
	private FilterRepo repository;
	
	@Override
	public List<FilterEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<FilterEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public FilterEntity update(long id, FilterEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public FilterEntity create(FilterEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
