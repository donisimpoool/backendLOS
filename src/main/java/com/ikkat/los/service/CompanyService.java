package com.ikkat.los.service;

import java.util.Optional;

import com.ikkat.los.entity.CompanyEntity;

public interface CompanyService {
	Optional<CompanyEntity> findById(String id);
}
