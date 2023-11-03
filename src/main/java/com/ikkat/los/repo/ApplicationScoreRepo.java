package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ApplicationScoreEntity;


@Repository("ApplicationScoreRepo")
public interface ApplicationScoreRepo extends JpaRepository<ApplicationScoreEntity, String>{

}
