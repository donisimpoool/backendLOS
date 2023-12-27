package com.ikkat.los.formapplication.applicationcollateraldeposit.handler;

import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDeposit;
import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDepositData;
import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.BodyApplicationCollateralDeposit;
import com.ikkat.los.formapplication.applicationcollateraldeposit.mapper.GetApplicationCollateralDepositData;
import com.ikkat.los.formapplication.applicationcollateraldeposit.repo.ApplicationCollateralDepositRepo;
import com.ikkat.los.formapplication.applicationcollateraldeposit.service.ApplicationCollateralDepositService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationCollateralDepositHandler implements ApplicationCollateralDepositService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationCollateralDepositRepo repository;

    @Override
    public List<ApplicationCollateralDepositData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralDepositData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralDepositData(), queryParameters);
    }

    @Override
    public ApplicationCollateralDepositData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralDepositData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationCollateralDepositData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralDepositData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationCollateralDepositData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralDepositData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralDepositData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralDeposit body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationCollateralDeposit table = new ApplicationCollateralDeposit();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setBankid(body.getBankid());
            table.setAmount(body.getAmount());
            table.setCurrency(body.getCurrency());
            table.setAccountnumber(body.getAccountnumber());
            table.setDuedate(body.getDuedate());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationCollateralDeposit body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationCollateralDeposit table = repository.getById(id);
            table.setBankid(body.getBankid());
            table.setAmount(body.getAmount());
            table.setCurrency(body.getCurrency());
            table.setAccountnumber(body.getAccountnumber());
            table.setDuedate(body.getDuedate());
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
