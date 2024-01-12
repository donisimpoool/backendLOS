package com.ikkat.los.roulesscores.handler;

import com.ikkat.los.roulesscores.entity.*;
import com.ikkat.los.roulesscores.mapper.GetRoulesData;
import com.ikkat.los.roulesscores.mapper.GetRoulesScoreMaxByGroup;
import com.ikkat.los.roulesscores.mapper.GetRoulesScoresData;
import com.ikkat.los.roulesscores.repo.RoulesScoresRepo;
import com.ikkat.los.roulesscores.service.RoulesScoresService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoulesScoresHandler implements RoulesScoresService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoulesScoresRepo repository;

    @Override
    public List<RoulesScoresData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoresData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoresData(), queryParameters);
    }

    @Override
    public RoulesScoresData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoresData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        List<RoulesScoresData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoresData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<RoulesScoresData> getListAllIsRoulesTemplate(Long idcompany, boolean isroulestemplate) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoresData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.isroulestemplate = "+isroulestemplate+" ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoresData(), queryParameters);
    }

    @Override
    public List<RoulesScoreMaxByGroup> getListRoulesMaxByGroup(Long idcompany, boolean isroulestemplate) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoreMaxByGroup().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.isroulestemplate = "+isroulestemplate+" GROUP BY data.groups ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoreMaxByGroup(), queryParameters);
    }

    @Override
    public List<RoulesData> getListAllByIsRoulesTemplate(Long idcompany, boolean isroulestemplate) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.isroulestemplate = "+isroulestemplate+" ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesData(), queryParameters);
    }

    @Override
    public ReturnData updateScore(Long idcompany, Long iduser, BodyUpdateScore body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            RoulesScores table = repository.findById(body.getId()).get();
            table.setScore(body.getScore());

            idsave = repository.saveAndFlush(table).getId();
        }catch (Exception e) {
            // TODO: handle exception
            ValidationDataMessage msg = new ValidationDataMessage(ConstansCodeMessage.CODE_MESSAGE_INTERNAL_SERVER_ERROR,"Kesalahan Pada Server");
            validations.add(msg);
        }
        ReturnData data = new ReturnData();
        data.setId(idsave);
        data.setSuccess(validations.size() > 0?false:true);
        data.setValidations(validations);
        return data;
    }
}
