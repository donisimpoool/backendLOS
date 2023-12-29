package com.ikkat.los.formapplication.application.handler;

import com.ikkat.los.formapplication.application.entity.Application;
import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.formapplication.application.entity.BodyApplication;
import com.ikkat.los.formapplication.application.mapper.GetDataApplication;
import com.ikkat.los.formapplication.application.repo.FormApplicationRepo;
import com.ikkat.los.formapplication.application.service.FormApplicationService;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.roulesscores.service.RoulesScoresService;
import com.ikkat.los.scoring.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.scoring.service.ScoringService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FormApplicationHandler implements FormApplicationService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationRepo repository;
    @Autowired
    private RoulesScoresService rulesService;

    @Autowired
    private ScoringService scoringService;

    @Override
    public List<ApplicationData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
    }

    @Override
    public ApplicationData getId(Long id,Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.id = ? and data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {id,idcompany};
        List<ApplicationData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, BodyApplication body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            long dateLong = new Date().getTime();
            java.sql.Date dtSql = new java.sql.Date(dateLong);
            Timestamp ts = new Timestamp(dateLong);
            Application table = new Application();
            table.setIdcompany(idcompany);
            table.setStatus(body.getStatus());
            table.setScore(body.getScore());
            table.setDateform(dtSql);
            table.setIsdraft(body.isIsdraft());
            table.setIdrisklevel(body.getIdrisklevel());
            table.setScorecardcomments(body.getScorecardcomments());
            table.setRuleenginecomments(body.getRuleenginecomments());
            table.setIsexport(body.isIsexport());
            table.setCreatedby(iduser);
            table.setCreateddate(ts);
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

    @Override
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplication body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            long dateLong = new Date().getTime();
            Timestamp ts = new Timestamp(dateLong);
            Application table = repository.getById(id);
            table.setStatus(body.getStatus());
            table.setScore(body.getScore());
            table.setIsdraft(body.isIsdraft());
            table.setIdrisklevel(body.getIdrisklevel());
            table.setScorecardcomments(body.getScorecardcomments());
            table.setRuleenginecomments(body.getRuleenginecomments());
            table.setIsexport(body.isIsexport());
            table.setCreatedby(iduser);
            table.setCreateddate(ts);
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

    @Override
    public ReturnData delete(Long idcompany, Long iduser, Long id) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        try{
                repository.deleteById(id);
        }catch (Exception e) {
            // TODO: handle exception
            ValidationDataMessage msg = new ValidationDataMessage(ConstansCodeMessage.CODE_MESSAGE_INTERNAL_SERVER_ERROR,"Kesalahan Pada Server");
            validations.add(msg);
        }
        ReturnData data = new ReturnData();
        data.setId(0);
        data.setSuccess(validations.size() > 0?false:true);
        data.setValidations(validations);
        return data;
    }

    @Override
    public List<ApplicationData> findByStatus(Long idcompany, String status) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.status = '"+status+"'  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
    }

    @Override
    public List<ApplicationData> findbystatusperpage(Long idcompany, String status, int sizelimit) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.status = '"+status+"'  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
    }

    @Override
    public List<ApplicationData> findbyIsDraft(Long idcompany, String status, boolean isdraft) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.isdraft = "+isdraft+" and data.status = '"+status+"' ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
    }

    @Override
    public List<ApplicationData> findbyOnlyIsDraft(Long idcompany, boolean isdraft) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplication().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.isdraft = "+isdraft+" ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplication(), queryParameters);
    }

    @Override
    public ReturnData saveAllApplication(Long idcompany, Long iduser, BodyAllApplication body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            long dateLong = new Date().getTime();
            java.sql.Date dtSql = new java.sql.Date(dateLong);

            BodyApplication bodyApp = body.getApplication();

            Timestamp ts = new Timestamp(dateLong);
            Application table = new Application();
            table.setIdcompany(idcompany);
            table.setStatus(bodyApp.getStatus());
            table.setScore(bodyApp.getScore());
            table.setDateform(dtSql);
            table.setIsdraft(bodyApp.isIsdraft());
            table.setIdrisklevel(bodyApp.getIdrisklevel());
            table.setScorecardcomments(bodyApp.getScorecardcomments());
            table.setRuleenginecomments(bodyApp.getRuleenginecomments());
            table.setIsexport(bodyApp.isIsexport());
            table.setCreatedby(iduser);
            table.setCreateddate(ts);
            idsave = repository.saveAndFlush(table).getId();

            //
            ParamsRoulesScoreEntity parmsroulesScore = scoringService.setValueParameter(idcompany,body);

            List<RoulesScoresData> listroules = rulesService.getListAllIsRoulesTemplate(idcompany,false);
            if(listroules.size() == 0) {
                listroules.clear();
                listroules = rulesService.getListAllIsRoulesTemplate(idcompany,true);
            }

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
