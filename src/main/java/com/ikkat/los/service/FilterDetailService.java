package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterDetailEntityPK;


public interface FilterDetailService {
	List<FilterDetailEntity> findAll();
	Optional<FilterDetailEntity> findById(FilterDetailEntityPK id);

	FilterDetailEntity update(FilterDetailEntityPK id, FilterDetailEntity cs);

	FilterDetailEntity create(FilterDetailEntity cs);
    
    void delete(FilterDetailEntityPK id);
    
    void saveAll(List<FilterDetailEntity> listdetail);
    
    List<FilterDetailEntity> listdetailByHeaderid(String filterhid);
    
    List<FilterDetailEntity> listdetailByListHeaderid(List<String> listid);
    
    int deleteByListHeaderID(List<String> listid);
    
    void deleteByHeaderID(String filterhid);
}
