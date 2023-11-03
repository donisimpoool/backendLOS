package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ListDocumentEntity;

@Repository("ListDocumentRepo")
public interface ListDocumentRepo extends JpaRepository<ListDocumentEntity, Long>{
	@Query(value =" select * from m_list_document "
			+ " where applicationid = :applicationid  ",nativeQuery = true)
	public List<ListDocumentEntity> listdocumentbyappid(@Param("applicationid") String applicationid);
}
