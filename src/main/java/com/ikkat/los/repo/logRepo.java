package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.LogEntity;

@Repository("logRepo")
public interface logRepo extends JpaRepository<LogEntity, Long>{

}
