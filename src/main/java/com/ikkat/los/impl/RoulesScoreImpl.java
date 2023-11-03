package com.ikkat.los.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreMaxEntity;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.repo.RoulesScoreRepo;
import com.ikkat.los.service.RoulesScoreService;

@Service
public class RoulesScoreImpl implements RoulesScoreService{
	@Autowired
	private RoulesScoreRepo repository;
	
	@Override
	public double CalculateScore(ParamsRoulesScoreEntity params,String education,String industrysector,
//			String jobtittle,
			double debtincomeratio) {
		// TODO Auto-generated method stub
		return repository.SumScore(params,education,industrysector,
//				jobtittle,
				debtincomeratio);
	}

	@Override
	public List<RoulesScoreEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public RoulesScoreEntity update(long id, RoulesScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public RoulesScoreEntity create(RoulesScoreEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public Optional<RoulesScoreEntity> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<RoulesScoreEntity> getlistroulesByTemplate(boolean isroulestemplate) {
		// TODO Auto-generated method stub
		return repository.getlistroulesByTemplate(isroulestemplate);
	}

	@Override
	public List<RoulesScoreEntity> getlistroulesByTemplateByPage(boolean isroulestemplate, int sizelimit) {
		// TODO Auto-generated method stub
		return repository.getlistroulesByTemplateByPage(isroulestemplate, sizelimit);
	}

	@Override
	public List<Object> getlistroulesMaxScore(boolean isroulestemplate) {
		// TODO Auto-generated method stub
		return repository.getlistroulesMaxScore(isroulestemplate);
	}

	@Override
	public RoulesScoreEntity getroulesByGroup(boolean isroulestemplate, String groups, String value) {
		// TODO Auto-generated method stub
		return repository.getroulesByGroup(isroulestemplate, groups, value);
	}

}
