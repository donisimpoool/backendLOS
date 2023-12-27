package com.ikkat.los.formapplication.applicationfamily.repo;

import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationFamilyRepo")
public interface FormApplicationFamilyRepo extends JpaRepository<ApplicationFamily, Long> {
}
