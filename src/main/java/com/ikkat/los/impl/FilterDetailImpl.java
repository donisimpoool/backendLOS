package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterDetailEntityPK;
import com.ikkat.los.repo.FilterDetailRepo;
import com.ikkat.los.service.FilterDetailService;

@Service
public class FilterDetailImpl implements FilterDetailService{
	@Autowired
	private FilterDetailRepo repository;
	
	@Override
	public List<FilterDetailEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<FilterDetailEntity> findById(FilterDetailEntityPK id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public FilterDetailEntity update(FilterDetailEntityPK id, FilterDetailEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public FilterDetailEntity create(FilterDetailEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(FilterDetailEntityPK id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<FilterDetailEntity> listdetailByHeaderid(String filterhid) {
		// TODO Auto-generated method stub
		return repository.listdetailByHeaderid(filterhid);
	}

	@Override
	public void saveAll(List<FilterDetailEntity> listdetail) {
		// TODO Auto-generated method stub
		repository.saveAll(listdetail);
		
	}

	@Override
	public List<FilterDetailEntity> listdetailByListHeaderid(List<String> listid) {
		// TODO Auto-generated method stub
		return repository.listdetailByListHeaderid(listid);
	}

	@Override
	public int deleteByListHeaderID(List<String> listid) {
		// TODO Auto-generated method stub
		return repository.deleteByListHeaderID(listid);
	}

	@Override
	public void deleteByHeaderID(String filterhid) {
		// TODO Auto-generated method stub
		 repository.deleteByHeaderID(filterhid);
		
	}

}
