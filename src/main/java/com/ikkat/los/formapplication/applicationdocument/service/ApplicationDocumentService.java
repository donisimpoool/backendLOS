package com.ikkat.los.formapplication.applicationdocument.service;

import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocumentData;
import com.ikkat.los.formapplication.applicationdocument.entity.BodyApplicationDocument;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationDocumentService {
    List<ApplicationDocumentData> getListAll(Long idcompany);
    ApplicationDocumentData getId(Long id,Long idcompany);
    List<ApplicationDocumentData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationDocument body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationDocument body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
