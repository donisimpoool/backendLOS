package com.ikkat.los.formapplication.applicationcollateraldeposit.service;

import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDepositData;
import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.BodyApplicationCollateralDeposit;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationCollateralDepositService {
    List<ApplicationCollateralDepositData> getListAll(Long idcompany);
    ApplicationCollateralDepositData getId(Long id,Long idcompany);
    List<ApplicationCollateralDepositData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralDeposit body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationCollateralDeposit body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
