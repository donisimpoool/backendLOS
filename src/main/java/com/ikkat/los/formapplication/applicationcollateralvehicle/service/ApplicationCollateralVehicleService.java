package com.ikkat.los.formapplication.applicationcollateralvehicle.service;

import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.ApplicationCollateralVehicleData;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.BodyApplicationCollateralVehicle;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationCollateralVehicleService {
    List<ApplicationCollateralVehicleData> getListAll(Long idcompany);
    ApplicationCollateralVehicleData getId(Long id,Long idcompany);
    List<ApplicationCollateralVehicleData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralVehicle body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationCollateralVehicle body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
