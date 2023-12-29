package com.ikkat.los.scoring.service;

import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.scoring.entity.ParamsRoulesScoreEntity;

import java.util.HashMap;
import java.util.List;

public interface ScoringService {
    ParamsRoulesScoreEntity setValueParameter(Long idcompany, BodyAllApplication body);
    HashMap<String, Object> calculateScore(Long idcompany,List<RoulesScoresData> listRoules, BodyAllApplication body);
}
