package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.FilterEntity;


@Repository("FilterRepo")
public interface FilterRepo extends JpaRepository<FilterEntity, Long>{

}
