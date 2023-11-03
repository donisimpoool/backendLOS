package com.ikkat.los.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.MenuItemsEntity;
import com.ikkat.los.repo.MenuItemsRepo;
import com.ikkat.los.service.MenuHeaderService;
import com.ikkat.los.service.MenuItemsService;

@Service
public class MenuItemsImpl implements MenuItemsService{
	@Autowired
	private MenuItemsRepo repository;
	
	@Override
	public List<MenuItemsEntity> getListMenuItems(int level, String menuheaderid) {
		// TODO Auto-generated method stub
		return repository.getListMenuItems(level, menuheaderid);
	}
	
}
