package com.ikkat.los.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.MenuHeaderEntity;
import com.ikkat.los.repo.MenuHeaderRepo;
import com.ikkat.los.service.MenuHeaderService;

@Service
public class MenuHeaderImpl implements MenuHeaderService{
	@Autowired
	private MenuHeaderRepo repository;
	
	@Override
	public List<MenuHeaderEntity> getListMenuHeader(int level, String type) {
		// TODO Auto-generated method stub
		return repository.getListMenuHeader(level, type);
	}

}
