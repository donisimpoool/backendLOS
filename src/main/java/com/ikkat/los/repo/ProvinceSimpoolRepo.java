package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ProvinceSimpoolEntity;

@Repository("ProvinceSimpoolRepo")
public interface ProvinceSimpoolRepo extends JpaRepository<ProvinceSimpoolEntity, String>{

}
