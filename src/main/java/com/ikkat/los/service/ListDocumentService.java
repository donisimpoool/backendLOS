package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ListDocumentEntity;
import com.ikkat.los.entity.LoanapplicationEntity;

public interface ListDocumentService {
	List<ListDocumentEntity> findAll();
	Optional<ListDocumentEntity> findById(long id);

	ListDocumentEntity update(long id, ListDocumentEntity cs);

	ListDocumentEntity create(ListDocumentEntity cs);
    
    void delete(long id);
    
    List<ListDocumentEntity> listdocumentbyappid(String applicationid);
}
