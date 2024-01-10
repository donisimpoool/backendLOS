package com.ikkat.los.roulesscores.service;

import com.ikkat.los.roulesscores.entity.BodyUpdateScore;
import com.ikkat.los.roulesscores.entity.RoulesData;
import com.ikkat.los.roulesscores.entity.RoulesScoreMaxByGroup;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface RoulesScoresService {

    List<RoulesScoresData> getListAll(Long idcompany);
    RoulesScoresData getId(Long id,Long idcompany);
    List<RoulesScoresData> getListAllIsRoulesTemplate(Long idcompany,boolean isroulestemplate);
    List<RoulesScoreMaxByGroup> getListRoulesMaxByGroup(Long idcompany, boolean isroulestemplate);
    List<RoulesData> getListAllByIsRoulesTemplate(Long idcompany, boolean isroulestemplate);
//    ReturnData save(Long idcompany, Long iduser, BodyApplication body);
    ReturnData updateScore(Long idcompany, Long iduser, BodyUpdateScore body);
//    ReturnData delete(Long idcompany,Long iduser,Long id);
}
