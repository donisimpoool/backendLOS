package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.repo.RiskLevelRepo;
import com.ikkat.los.service.RiskLevelService;

@Service
public class RiskLevelImpl implements RiskLevelService {
	@Autowired
	private RiskLevelRepo repository;
	
	@Override
	public List<RiskLevelEntity> getRiskByRangeScore(double score) {
		// TODO Auto-generated method stub
		return repository.getRiskByRangeScore(score);
	}

	@Override
	public List<RiskLevelEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<RiskLevelEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public RiskLevelEntity update(long id, RiskLevelEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public RiskLevelEntity create(RiskLevelEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}
