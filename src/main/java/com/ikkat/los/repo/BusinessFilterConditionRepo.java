package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.entity.BusinessFilterEntity;

@Repository("BusinessFilterConditionRepo")
public interface BusinessFilterConditionRepo extends JpaRepository<BusinessFilterConditionsEntity, Long>{

}
