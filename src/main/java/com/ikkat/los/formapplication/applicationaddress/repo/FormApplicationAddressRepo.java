package com.ikkat.los.formapplication.applicationaddress.repo;

import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationAddressRepo")
public interface FormApplicationAddressRepo extends JpaRepository<ApplicationAddress, Long> {
}
