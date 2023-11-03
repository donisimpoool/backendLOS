package com.ikkat.los.service;

import java.util.List;


import com.ikkat.los.entity.SubDistrictEntity;

public interface SubDistrictService {
	List<SubDistrictEntity> GetListSubDistrict();
	
	List<SubDistrictEntity> GetListByDistrict(String iddistrict);
}
