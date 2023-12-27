package com.ikkat.los.formapplication.applicationcollateralrealestate.service;

import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateData;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.BodyApplicationCollateralRealEstate;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationCollateralRealEstateService {
    List<ApplicationCollateralRealEstateData> getListAll(Long idcompany);
    ApplicationCollateralRealEstateData getId(Long id,Long idcompany);
    List<ApplicationCollateralRealEstateData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralRealEstate body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationCollateralRealEstate body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
