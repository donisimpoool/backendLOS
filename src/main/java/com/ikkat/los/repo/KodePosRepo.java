package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.KodePosEntity;


@Repository("KodePosRepo")
public interface KodePosRepo extends JpaRepository<KodePosEntity, Long>{
	
	@Query(value =" select * from tbl_kodepos "
			+ " where kecamatan = :kecamatan  ",nativeQuery = true)
	public List<KodePosEntity> listkelurahanbykecamatan(@Param("kecamatan") String kecamatan);
}
