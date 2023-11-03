package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.applicationPersonelEntity;


@Repository("applicationPersoneRepo")
public interface applicationPersoneRepo extends JpaRepository<applicationPersonelEntity, String>{

}
