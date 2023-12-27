package com.ikkat.los.formapplication.applicationfamily.service;

import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyData;
import com.ikkat.los.formapplication.applicationfamily.entity.BodyApplicationFamily;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationFamilyService {
    List<ApplicationFamilyData> getListAll(Long idcompany);
    ApplicationFamilyData getId(Long id,Long idcompany);
    List<ApplicationFamilyData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationFamily body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationFamily body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
