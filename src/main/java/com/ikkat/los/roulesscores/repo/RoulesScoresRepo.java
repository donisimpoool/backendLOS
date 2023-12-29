package com.ikkat.los.roulesscores.repo;

import com.ikkat.los.roulesscores.entity.RoulesScores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoulesScoresRepo")
public interface RoulesScoresRepo extends JpaRepository<RoulesScores, Long> {
}
