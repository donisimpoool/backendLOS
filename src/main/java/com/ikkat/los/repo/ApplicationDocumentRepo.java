package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ApplicationDocumentEntity;

@Repository("ApplicationDocumentRepo")
public interface ApplicationDocumentRepo extends JpaRepository<ApplicationDocumentEntity, String>{

}
