package com.ikkat.los.risklevel.repo;

import com.ikkat.los.risklevel.entity.RiskLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RiskLevelRepoo")
public interface RiskLevelRepo extends JpaRepository<RiskLevel, Long> {
}
