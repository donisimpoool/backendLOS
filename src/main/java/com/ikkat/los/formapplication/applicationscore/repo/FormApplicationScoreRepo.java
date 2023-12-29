package com.ikkat.los.formapplication.applicationscore.repo;

import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationScoreRepo")
public interface FormApplicationScoreRepo extends JpaRepository<ApplicationScore, Long> {
}
