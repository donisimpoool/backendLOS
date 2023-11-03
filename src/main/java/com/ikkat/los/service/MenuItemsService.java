package com.ikkat.los.service;

import java.util.List;


import com.ikkat.los.entity.MenuItemsEntity;

public interface MenuItemsService {
	List<MenuItemsEntity> getListMenuItems(int level,String menuheaderid);
}
