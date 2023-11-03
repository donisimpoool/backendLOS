package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.LineBusinessEntity;

@Repository("LineBusinessRepo")
public interface LineBusinessRepo extends JpaRepository<LineBusinessEntity, String>{

}
