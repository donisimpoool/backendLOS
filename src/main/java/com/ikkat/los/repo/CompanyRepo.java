package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.CompanyEntity;

@Repository("CompanyRepo")
public interface CompanyRepo extends JpaRepository<CompanyEntity, String>{

}
