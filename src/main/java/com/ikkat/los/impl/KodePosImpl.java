package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.KodePosEntity;
import com.ikkat.los.repo.KodePosRepo;
import com.ikkat.los.service.KodePosService;

@Service
public class KodePosImpl implements KodePosService {
	@Autowired
	private KodePosRepo repository;
	
	@Override
	public List<KodePosEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<KodePosEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public KodePosEntity update(long id, KodePosEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public KodePosEntity create(KodePosEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public List<KodePosEntity> listkelurahanbykecamatan(String kecamatan) {
		// TODO Auto-generated method stub
		return repository.listkelurahanbykecamatan(kecamatan);
	}

}
