package com.ikkat.los.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.CreditScoreEntity;

@Repository("creditScoreRepo")
public interface creditScoreRepo extends JpaRepository<CreditScoreEntity, Long> {
	Optional<CreditScoreEntity> findById(Long id);
}
