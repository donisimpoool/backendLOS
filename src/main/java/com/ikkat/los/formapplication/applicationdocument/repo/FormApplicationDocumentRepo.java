package com.ikkat.los.formapplication.applicationdocument.repo;

import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationDocumentRepo")
public interface FormApplicationDocumentRepo extends JpaRepository<ApplicationDocument, Long> {
}
