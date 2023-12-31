package com.ikkat.los.formapplication.application.handler;

import com.ikkat.los.enumeration.TypeCollateral;
import com.ikkat.los.formapplication.application.entity.Application;
import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.formapplication.application.entity.BodyApplication;
import com.ikkat.los.formapplication.application.mapper.GetDataApplication;
import com.ikkat.los.formapplication.application.repo.FormApplicationRepo;
import com.ikkat.los.formapplication.application.service.FormApplicationService;
import com.ikkat.los.formapplication.applicationaddress.service.FormApplicationAddressService;
import com.ikkat.los.formapplication.applicationbank.service.FormApplicationBankService;
import com.ikkat.los.formapplication.applicationbusiness.service.FormApplicationBusinessService;
import com.ikkat.los.formapplication.applicationcollateral.service.ApplicationCollateralService;
import com.ikkat.los.formapplication.applicationcollateraldeposit.service.ApplicationCollateralDepositService;
import com.ikkat.los.formapplication.applicationcollateralrealestate.service.ApplicationCollateralRealEstateService;
import com.ikkat.los.formapplication.applicationcollateralvehicle.service.ApplicationCollateralVehicleService;
import com.ikkat.los.formapplication.applicationfamily.service.ApplicationFamilyService;
import com.ikkat.los.formapplication.applicationfinancial.service.ApplicationFinancialService;
import com.ikkat.los.formapplication.applicationloan.service.ApplicationLoanService;
import com.ikkat.los.formapplication.applicationpersonal.service.ApplicationPersonalService;
import com.ikkat.los.formapplication.applicationscore.entity.BodyApplicationScore;
import com.ikkat.los.formapplication.applicationscore.service.ApplicationScoreService;
import com.ikkat.los.risklevel.entity.RiskLevelData;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.roulesscores.service.RoulesScoresService;
import com.ikkat.los.scoring.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.scoring.service.ScoringService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import com.ikkat.los.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private ApplicationScoreService applicationScoreService;
    @Autowired
    private ApplicationLoanService applicationLoanService;
    @Autowired
    private ApplicationPersonalService applicationPersonalService;
    @Autowired
    private FormApplicationAddressService applicationAddressService;
    @Autowired
    private ApplicationFamilyService applicationFamilyService;
    @Autowired
    private FormApplicationBusinessService applicationBusinessService;
    @Autowired
    private ApplicationFinancialService applicationFinancialService;
    @Autowired
    private FormApplicationBankService applicationBankService;
    @Autowired
    private ApplicationCollateralService applicationCollateralService;
    @Autowired
    private ApplicationCollateralRealEstateService applicationCollateralRealEstateService;
    @Autowired
    private ApplicationCollateralVehicleService applicationCollateralVehicleService;
    @Autowired
    private ApplicationCollateralDepositService applicationCollateralDepositService;

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
            Timestamp ts = new Timestamp(dateLong);

            List<RoulesScoresData> listroules = rulesService.getListAllIsRoulesTemplate(idcompany,false);
            if(listroules.size() == 0) {
                listroules.clear();
                listroules = rulesService.getListAllIsRoulesTemplate(idcompany,true);
            }
            HashMap<String, Object> mapScore = scoringService.calculateScore(idcompany,listroules,body);
            int score = (int) mapScore.get("hasilscore");
            RiskLevelData risk = (RiskLevelData) mapScore.get("risk");
            String status = (String) mapScore.get("status");
//            String ruleEnginecomments = (String) mapscore.get("ruleEnginecomments");
            BodyApplicationScore detailscore = (BodyApplicationScore) mapScore.get("detailscore");

            boolean isrealestate = Validation.checkCollateral(TypeCollateral.REALESTATE.value(),
                    body.getApplicationcollateral().getCollateral());
            boolean isvehicle = Validation.checkCollateral(TypeCollateral.VEHICLE.value(),
                    body.getApplicationcollateral().getCollateral());
            boolean isdeposit = Validation.checkCollateral(TypeCollateral.DEPOSIT.value(),
                    body.getApplicationcollateral().getCollateral());

            Application table = new Application();
            table.setIdcompany(idcompany);
            table.setStatus(status);
            table.setScore(score);
            table.setDateform(dtSql);
            table.setIsdraft(body.isIsdraft());
            table.setIdrisklevel(risk.getId());
            table.setScorecardcomments("");
            table.setRuleenginecomments("");
            table.setIsexport(false);
            table.setCreatedby(iduser);
            table.setCreateddate(ts);
            idsave = repository.saveAndFlush(table).getId();

            applicationScoreService.save(idcompany,iduser,idsave,detailscore);
            applicationLoanService.save(idcompany,iduser,idsave, body.getApplicationloan());
            applicationPersonalService.save(idcompany,iduser,idsave, body.getApplicationpersonal());
            applicationAddressService.save(idcompany,iduser,idsave, body.getApplicationaddress());
            applicationFamilyService.save(idcompany,iduser,idsave, body.getApplicationfamily());
            applicationBusinessService.save(idcompany,iduser,idsave, body.getApplicationbusiness());
            applicationFinancialService.save(idcompany,iduser,idsave, body.getApplicationfinancial());
            applicationBankService.save(idcompany,iduser,idsave, body.getApplicationbank());
            applicationCollateralService.save(idcompany,iduser,idsave, body.getApplicationcollateral());
            if (isrealestate) {
                applicationCollateralRealEstateService.save(idcompany,iduser,idsave, body.getApplicationCollateralRealEstate());
            }else if (isvehicle) {
                applicationCollateralVehicleService.save(idcompany,iduser,idsave, body.getApplicationCollateralVehicle());
            }else if (isdeposit) {
                applicationCollateralDepositService.save(idcompany,iduser,idsave, body.getApplicationCollateralDeposit());
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
