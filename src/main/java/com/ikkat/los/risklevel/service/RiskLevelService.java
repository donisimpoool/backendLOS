package com.ikkat.los.risklevel.service;

import com.ikkat.los.risklevel.entity.BodyRiskLevel;
import com.ikkat.los.risklevel.entity.RiskLevelData;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface RiskLevelService {
    List<RiskLevelData> getRiskByRangeScore(Long idcompany,double score);
    List<RiskLevelData> getListAll(Long idcompany);
    RiskLevelData getId(Long id,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, BodyRiskLevel body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyRiskLevel body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
