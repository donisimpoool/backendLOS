package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ReligionEntity;

@Repository("ReligionRepo")
public interface ReligionRepo extends JpaRepository<ReligionEntity, String>{

}
