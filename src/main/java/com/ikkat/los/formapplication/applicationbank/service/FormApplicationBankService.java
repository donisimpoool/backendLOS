package com.ikkat.los.formapplication.applicationbank.service;

import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBankData;
import com.ikkat.los.formapplication.applicationbank.entity.BodyApplicationBank;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface FormApplicationBankService {
    List<ApplicationBankData> getListAll(Long idcompany);
    ApplicationBankData getId(Long id,Long idcompany);
    List<ApplicationBankData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationBank body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationBank body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
