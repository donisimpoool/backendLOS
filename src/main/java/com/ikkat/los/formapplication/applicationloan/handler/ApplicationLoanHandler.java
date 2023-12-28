package com.ikkat.los.formapplication.applicationloan.handler;

import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoan;
import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoanData;
import com.ikkat.los.formapplication.applicationloan.entity.BodyApplicationLoan;
import com.ikkat.los.formapplication.applicationloan.mapper.GetApplicationLoanData;
import com.ikkat.los.formapplication.applicationloan.repo.FormApplicationLoanRepo;
import com.ikkat.los.formapplication.applicationloan.service.ApplicationLoanService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationLoanHandler implements ApplicationLoanService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationLoanRepo repository;

    @Override
    public List<ApplicationLoanData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationLoanData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationLoanData(), queryParameters);
    }

    @Override
    public ApplicationLoanData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationLoanData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationLoanData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationLoanData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationLoanData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationLoanData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationLoanData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationLoan body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationLoan table = new ApplicationLoan();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setLoanproductid(body.getLoanproductid());
            table.setPurposeofloan(body.getPurposeofloan());
            table.setTenor(body.getTenor());
            table.setAmount(body.getAmount());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationLoan body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationLoan table = repository.getById(id);
            table.setLoanproductid(body.getLoanproductid());
            table.setPurposeofloan(body.getPurposeofloan());
            table.setTenor(body.getTenor());
            table.setAmount(body.getAmount());
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
