package com.ikkat.los.formapplication.applicationscore.service;

import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScoreData;
import com.ikkat.los.formapplication.applicationscore.entity.BodyApplicationScore;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationScoreService {
    List<ApplicationScoreData> getListAll(Long idcompany);
    ApplicationScoreData getId(Long id,Long idcompany);
    List<ApplicationScoreData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationScore body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationScore body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
