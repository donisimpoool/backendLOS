package com.ikkat.los.formapplication.applicationpersonal.service;

import com.ikkat.los.formapplication.applicationpersonal.entity.ApplicationPersonalData;
import com.ikkat.los.formapplication.applicationpersonal.entity.BodyApplicationPersonal;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationPersonalService {
    List<ApplicationPersonalData> getListAll(Long idcompany);
    ApplicationPersonalData getId(Long id,Long idcompany);
    List<ApplicationPersonalData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationPersonal body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationPersonal body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
