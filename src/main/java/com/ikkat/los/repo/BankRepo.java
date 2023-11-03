package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.BankEntity;

@Repository("BankRepo")
public interface BankRepo extends JpaRepository<BankEntity, String>{

}
