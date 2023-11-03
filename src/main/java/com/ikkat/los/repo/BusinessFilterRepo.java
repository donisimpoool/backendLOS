package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.BusinessFilterEntity;

@Repository("BusinessFilterRepo")
public interface BusinessFilterRepo extends JpaRepository<BusinessFilterEntity, Long>{

}
