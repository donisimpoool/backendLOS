package com.ikkat.los.formapplication.applicationaddress.service;

import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddressData;
import com.ikkat.los.formapplication.applicationaddress.entity.BodyApplicationAddress;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface FormApplicationAddressService {
    List<ApplicationAddressData> getListAll(Long idcompany);
    ApplicationAddressData getId(Long id,Long idcompany);
    List<ApplicationAddressData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser,Long idapplication, BodyApplicationAddress body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationAddress body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
