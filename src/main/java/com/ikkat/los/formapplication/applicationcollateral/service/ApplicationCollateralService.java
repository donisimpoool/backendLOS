package com.ikkat.los.formapplication.applicationcollateral.service;

import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralData;
import com.ikkat.los.formapplication.applicationcollateral.entity.BodyApplicationCollateral;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationCollateralService {
    List<ApplicationCollateralData> getListAll(Long idcompany);
    ApplicationCollateralData getId(Long id,Long idcompany);
    List<ApplicationCollateralData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateral body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationCollateral body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
