package com.ikkat.los.formapplication.application.repo;

import com.ikkat.los.formapplication.application.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationRepo")
public interface FormApplicationRepo extends JpaRepository<Application, Long> {
}
