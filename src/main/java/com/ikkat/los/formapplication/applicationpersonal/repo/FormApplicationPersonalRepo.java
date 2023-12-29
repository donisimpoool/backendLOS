package com.ikkat.los.formapplication.applicationpersonal.repo;

import com.ikkat.los.formapplication.applicationpersonal.entity.ApplicationPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationPersonalRepo")
public interface FormApplicationPersonalRepo extends JpaRepository<ApplicationPersonal, Long> {
}
