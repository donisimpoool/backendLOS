package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.CustomerBlacklistEntity;

@Repository("CustomerBlacklistRepo")
public interface CustomerBlacklistRepo extends JpaRepository<CustomerBlacklistEntity, Long>{

}
