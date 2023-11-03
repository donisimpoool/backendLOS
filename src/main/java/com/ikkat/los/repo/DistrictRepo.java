package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.DistrictEntity;


@Repository("DistrictRepo")
public interface DistrictRepo extends JpaRepository<DistrictEntity, String>{

}
