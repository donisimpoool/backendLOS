package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.UrlEntity;
import com.ikkat.los.entity.UserEntity;

public interface UrlService {
	List<UrlEntity> findAll();
	Optional<UrlEntity> findById(String id);
	UrlEntity update(String id, UrlEntity cs);

	UrlEntity create(UrlEntity cs);
}
