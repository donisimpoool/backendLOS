package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.KodePosEntity;

public interface KodePosService {
	List<KodePosEntity> findAll();
	Optional<KodePosEntity> findById(long id);

	KodePosEntity update(long id, KodePosEntity cs);

	KodePosEntity create(KodePosEntity cs);
    
    void delete(long id);
    
    List<KodePosEntity> listkelurahanbykecamatan(String kecamatan);
}
