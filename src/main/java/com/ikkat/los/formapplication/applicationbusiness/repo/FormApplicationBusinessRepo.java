package com.ikkat.los.formapplication.applicationbusiness.repo;
import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationBusinessRepo")
public interface FormApplicationBusinessRepo extends JpaRepository<FormApplicationBusiness, Long> {
}
