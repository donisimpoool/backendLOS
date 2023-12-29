package com.ikkat.los.formapplication.applicationscore.handler;

import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScore;
import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScoreData;
import com.ikkat.los.formapplication.applicationscore.entity.BodyApplicationScore;
import com.ikkat.los.formapplication.applicationscore.mapper.GetApplicationScoreData;
import com.ikkat.los.formapplication.applicationscore.repo.FormApplicationScoreRepo;
import com.ikkat.los.formapplication.applicationscore.service.ApplicationScoreService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationScoreHandler implements ApplicationScoreService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationScoreRepo repository;

    @Override
    public List<ApplicationScoreData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationScoreData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationScoreData(), queryParameters);
    }

    @Override
    public ApplicationScoreData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationScoreData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationScoreData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationScoreData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationScoreData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationScoreData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationScoreData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationScore body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationScore table = new ApplicationScore();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setPropertypossession(body.getPropertypossession());
            table.setNumberofdependant(body.getNumberofdependant());
            table.setGender(body.getGender());
            table.setLocations(body.getLocations());
            table.setLiveownershipstatus(body.getLiveownershipstatus());
            table.setVehicleowner(body.getVehicleowner());
            table.setMaritalstatus(body.getMaritalstatus());
            table.setCompanysize(body.getCompanysize());
            table.setCreditcardowner(body.getCreditcardowner());
            table.setDebtincomeratio(body.getDebtincomeratio());
            table.setIndustrysector(body.getIndustrysector());
            table.setEducation(body.getEducation());
            table.setIncometype(body.getIncometype());
            table.setAge(body.getAge());
            table.setDurationwork(body.getDurationwork());
            table.setJobtittle(body.getJobtittle());
            table.setPositions(body.getPositions());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationScore body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationScore table = repository.getById(id);
            table.setPropertypossession(body.getPropertypossession());
            table.setNumberofdependant(body.getNumberofdependant());
            table.setGender(body.getGender());
            table.setLocations(body.getLocations());
            table.setLiveownershipstatus(body.getLiveownershipstatus());
            table.setVehicleowner(body.getVehicleowner());
            table.setMaritalstatus(body.getMaritalstatus());
            table.setCompanysize(body.getCompanysize());
            table.setCreditcardowner(body.getCreditcardowner());
            table.setDebtincomeratio(body.getDebtincomeratio());
            table.setIndustrysector(body.getIndustrysector());
            table.setEducation(body.getEducation());
            table.setIncometype(body.getIncometype());
            table.setAge(body.getAge());
            table.setDurationwork(body.getDurationwork());
            table.setJobtittle(body.getJobtittle());
            table.setPositions(body.getPositions());

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
        return null;
    }
}
