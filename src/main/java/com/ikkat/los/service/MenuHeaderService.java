package com.ikkat.los.service;

import java.util.List;


import com.ikkat.los.entity.MenuHeaderEntity;

public interface MenuHeaderService {
	
	List<MenuHeaderEntity> getListMenuHeader(int level,String type);
}
