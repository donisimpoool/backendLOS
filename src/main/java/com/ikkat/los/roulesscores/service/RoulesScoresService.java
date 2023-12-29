package com.ikkat.los.roulesscores.service;

import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface RoulesScoresService {

    List<RoulesScoresData> getListAll(Long idcompany);
    RoulesScoresData getId(Long id,Long idcompany);
    List<RoulesScoresData> getListAllIsRoulesTemplate(Long idcompany,boolean isroulestemplate);
//    ReturnData save(Long idcompany, Long iduser, BodyApplication body);
//    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplication body);
//    ReturnData delete(Long idcompany,Long iduser,Long id);
}
