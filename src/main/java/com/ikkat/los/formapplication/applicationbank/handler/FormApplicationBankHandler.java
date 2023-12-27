package com.ikkat.los.formapplication.applicationbank.handler;

import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBank;
import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBankData;
import com.ikkat.los.formapplication.applicationbank.entity.BodyApplicationBank;
import com.ikkat.los.formapplication.applicationbank.mapper.GetApplicationBankData;
import com.ikkat.los.formapplication.applicationbank.repo.ApplicationBankRepo;
import com.ikkat.los.formapplication.applicationbank.service.FormApplicationBankService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormApplicationBankHandler implements FormApplicationBankService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationBankRepo repository;

    @Override
    public List<ApplicationBankData> getListAll(Long idcompany) {

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBankData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBankData(), queryParameters);
    }

    @Override
    public ApplicationBankData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBankData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationBankData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBankData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationBankData> getByIdApplication(Long idapplication, Long idcompany) {

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationBankData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationBankData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationBank body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationBank table = new ApplicationBank();
            table.setIdcompany(idcompany);
            table.setIdapplication(idapplication);
            table.setBankid(body.getBankid());
            table.setAccounttype(body.getAccounttype());
            table.setAccountnumber(body.getAccountnumber());
            table.setIscreditcard(body.isIscreditcard());
            table.setBankcc(body.getBankcc());
            table.setNumbercc(body.getNumbercc());
            table.setTypecredittcard(body.getTypecredittcard());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationBank body) {

        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationBank table = repository.getById(id);
            table.setBankid(body.getBankid());
            table.setAccounttype(body.getAccounttype());
            table.setAccountnumber(body.getAccountnumber());
            table.setIscreditcard(body.isIscreditcard());
            table.setBankcc(body.getBankcc());
            table.setNumbercc(body.getNumbercc());
            table.setTypecredittcard(body.getTypecredittcard());
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
