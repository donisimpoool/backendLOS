package com.ikkat.los.formapplication.applicationpersonal.handler;

import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoan;
import com.ikkat.los.formapplication.applicationloan.mapper.GetApplicationLoanData;
import com.ikkat.los.formapplication.applicationloan.repo.FormApplicationLoanRepo;
import com.ikkat.los.formapplication.applicationloan.service.ApplicationLoanService;
import com.ikkat.los.formapplication.applicationpersonal.entity.ApplicationPersonal;
import com.ikkat.los.formapplication.applicationpersonal.entity.ApplicationPersonalData;
import com.ikkat.los.formapplication.applicationpersonal.entity.BodyApplicationPersonal;
import com.ikkat.los.formapplication.applicationpersonal.mapper.GetApplicationPersonalData;
import com.ikkat.los.formapplication.applicationpersonal.repo.FormApplicationPersonalRepo;
import com.ikkat.los.formapplication.applicationpersonal.service.ApplicationPersonalService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationPersonalHandler implements ApplicationPersonalService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationPersonalRepo repository;

    @Override
    public List<ApplicationPersonalData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationPersonalData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationPersonalData(), queryParameters);
    }

    @Override
    public ApplicationPersonalData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationPersonalData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationPersonalData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationPersonalData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationPersonalData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationPersonalData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationPersonalData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationPersonal body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationPersonal table = new ApplicationPersonal();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setNames(body.getNames());
            table.setMobilephone(body.getMobilephone());
            table.setLandlinephone(body.getLandlinephone());
            table.setPlaceofbirth(body.getPlaceofbirth());
            table.setDateofbirth(new Date(body.getDateofbirthtime()));
            table.setGender(body.getGender());
            table.setTypeid(body.getTypeid());
            table.setEducation(body.getEducation());
            table.setMaritalstatus(body.getMaritalstatus());
            table.setEmail(body.getEmail());
            table.setIdnumber(body.getIdnumber());
            table.setNumberofdependant(body.getNumberofdependant());
            table.setReligionid(body.getReligionid());
            table.setTaxnumber(body.getTaxnumber());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationPersonal body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationPersonal table = repository.getById(id);
            table.setNames(body.getNames());
            table.setMobilephone(body.getMobilephone());
            table.setLandlinephone(body.getLandlinephone());
            table.setPlaceofbirth(body.getPlaceofbirth());
            table.setDateofbirth(new Date(body.getDateofbirthtime()));
            table.setGender(body.getGender());
            table.setTypeid(body.getTypeid());
            table.setEducation(body.getEducation());
            table.setMaritalstatus(body.getMaritalstatus());
            table.setEmail(body.getEmail());
            table.setIdnumber(body.getIdnumber());
            table.setNumberofdependant(body.getNumberofdependant());
            table.setReligionid(body.getReligionid());
            table.setTaxnumber(body.getTaxnumber());

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
