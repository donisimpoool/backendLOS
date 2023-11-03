package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikkat.los.entity.ApplicationBankEntity;


public interface ApplicationBankRepo extends JpaRepository<ApplicationBankEntity, String>{

}
