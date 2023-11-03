package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.UrlEntity;

@Repository("UrlRepo")
public interface UrlRepo extends JpaRepository<UrlEntity, String>{

}
