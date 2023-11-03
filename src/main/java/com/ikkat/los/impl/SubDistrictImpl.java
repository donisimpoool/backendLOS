package com.ikkat.los.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.SubDistrictEntity;
import com.ikkat.los.repo.SubDistrictRepo;
import com.ikkat.los.service.SubDistrictService;

@Service
public class SubDistrictImpl implements SubDistrictService {
	@Autowired
	private SubDistrictRepo repository;
	
	@Override
	public List<SubDistrictEntity> GetListSubDistrict() {
		// TODO Auto-generated method stub
		return repository.GetListSubDistrict();
	}

	@Override
	public List<SubDistrictEntity> GetListByDistrict(String iddistrict) {
		// TODO Auto-generated method stub
		return repository.GetListByDistrict(iddistrict);
	}

}
