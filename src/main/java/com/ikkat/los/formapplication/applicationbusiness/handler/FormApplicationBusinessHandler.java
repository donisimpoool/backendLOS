package com.ikkat.los.formapplication.applicationbusiness.handler;

import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBank;
import com.ikkat.los.formapplication.applicationbank.mapper.GetApplicationBankData;
import com.ikkat.los.formapplication.applicationbusiness.entity.BodyFormApplicationBusiness;
import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusiness;
import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusinessData;
import com.ikkat.los.formapplication.applicationbusiness.mapper.GetApplicationBusinessData;
import com.ikkat.los.formapplication.applicationbusiness.repo.FormApplicationBusinessRepo;
import com.ikkat.los.formapplication.applicationbusiness.service.FormApplicationBusinessService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormApplicationBusinessHandler implements FormApplicationBusinessService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationBusinessRepo repository;

    @Override
    public List<FormApplicationBusinessData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBusinessData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBusinessData(), queryParameters);
    }

    @Override
    public FormApplicationBusinessData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBusinessData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<FormApplicationBusinessData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBusinessData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<FormApplicationBusinessData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBusinessData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBusinessData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyFormApplicationBusiness body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            System.out.println("body.getCompanyname() "+body.getCompanyname());
            FormApplicationBusiness table = new FormApplicationBusiness();
            table.setIdcompany(idcompany);
            table.setIdapplication(idapplication);
            table.setCompanyname(body.getCompanyname());
            table.setCompanyaddress(body.getCompanyaddress());
            table.setDivision(body.getDivision());
            table.setPositions(body.getPositions());
            table.setDuration(body.getDuration());
            table.setNumberofemployees(body.getNumberofemployees());
            table.setBusinessline(body.getBusinessline());
            table.setIdregencies(body.getIdregencies());
            table.setIddistrict(body.getIddistrict());
            table.setProvinceid(body.getProvinceid());
            idsave = repository.saveAndFlush(table).getId();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception "+e.getMessage());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyFormApplicationBusiness body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            FormApplicationBusiness table = repository.findById(id).get();
            table.setCompanyname(body.getCompanyname());
            table.setCompanyaddress(body.getCompanyaddress());
            table.setDivision(body.getDivision());
            table.setPositions(body.getPositions());
            table.setDuration(body.getDuration());
            table.setNumberofemployees(body.getNumberofemployees());
            table.setBusinessline(body.getBusinessline());
            table.setIdregencies(body.getIdregencies());
            table.setIddistrict(body.getIddistrict());
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
