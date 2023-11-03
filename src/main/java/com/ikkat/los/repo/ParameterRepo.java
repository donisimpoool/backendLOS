package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ParameterEntity;

@Repository("ParameterRepo")
public interface ParameterRepo extends JpaRepository<ParameterEntity, String> {

}
