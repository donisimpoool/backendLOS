package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ApplicationFinancialEntity;

@Repository("ApplicationFinancialRepo")
public interface ApplicationFinancialRepo extends JpaRepository<ApplicationFinancialEntity, String>{

}
