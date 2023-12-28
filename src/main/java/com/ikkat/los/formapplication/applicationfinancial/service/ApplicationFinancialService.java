package com.ikkat.los.formapplication.applicationfinancial.service;

import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancialData;
import com.ikkat.los.formapplication.applicationfinancial.entity.BodyApplicationFinancial;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationFinancialService {
    List<ApplicationFinancialData> getListAll(Long idcompany);
    ApplicationFinancialData getId(Long id,Long idcompany);
    List<ApplicationFinancialData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationFinancial body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationFinancial body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
