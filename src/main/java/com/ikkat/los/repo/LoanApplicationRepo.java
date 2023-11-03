package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.LoanapplicationEntity;

@Repository("LoanApplicationRepo")
public interface LoanApplicationRepo extends JpaRepository<LoanapplicationEntity, String>{

}
