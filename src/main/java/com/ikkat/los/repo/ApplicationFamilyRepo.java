package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ApplicationFamilyEntity;

@Repository("ApplicationFamilyRepo")
public interface ApplicationFamilyRepo extends JpaRepository<ApplicationFamilyEntity, String>{

}
