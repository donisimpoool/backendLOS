package com.ikkat.los.formapplication.applicationbank.repo;

import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddress;
import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ApplicationBankRepo")
public interface ApplicationBankRepo extends JpaRepository<ApplicationBank, Long> {
}
