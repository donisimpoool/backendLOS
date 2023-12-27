package com.ikkat.los.formapplication.applicationbusiness.service;

import com.ikkat.los.formapplication.applicationbusiness.entity.BodyFormApplicationBusiness;
import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusinessData;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface FormApplicationBusinessService {
    List<FormApplicationBusinessData> getListAll(Long idcompany);
    FormApplicationBusinessData getId(Long id,Long idcompany);
    List<FormApplicationBusinessData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyFormApplicationBusiness body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyFormApplicationBusiness body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
