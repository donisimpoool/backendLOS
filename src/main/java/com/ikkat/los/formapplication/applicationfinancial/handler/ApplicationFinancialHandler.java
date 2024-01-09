package com.ikkat.los.formapplication.applicationfinancial.handler;

import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancial;
import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancialData;
import com.ikkat.los.formapplication.applicationfinancial.entity.BodyApplicationFinancial;
import com.ikkat.los.formapplication.applicationfinancial.mapper.GetApplicationFinancialData;
import com.ikkat.los.formapplication.applicationfinancial.repo.FormApplicationFinancialRepo;
import com.ikkat.los.formapplication.applicationfinancial.service.ApplicationFinancialService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationFinancialHandler implements ApplicationFinancialService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationFinancialRepo repository;

    @Override
    public List<ApplicationFinancialData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFinancialData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFinancialData(), queryParameters);
    }

    @Override
    public ApplicationFinancialData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFinancialData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationFinancialData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFinancialData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationFinancialData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFinancialData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFinancialData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationFinancial body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationFinancial table = new ApplicationFinancial();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setTypeincome(body.getTypeincome());
            table.setMainincome(body.getMainincome());
            table.setSideincome(body.getSideincome());
            table.setExpense(body.getExpense());
            table.setAdditionalexpense(body.getAdditionalexpense());
            table.setVehicleowner(body.getVehicleowner().equals("Y")?true:false);
            table.setTypevehicle(body.getTypevehicle());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationFinancial body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationFinancial table = repository.getById(id);
            table.setTypeincome(body.getTypeincome());
            table.setMainincome(body.getMainincome());
            table.setSideincome(body.getSideincome());
            table.setExpense(body.getExpense());
            table.setAdditionalexpense(body.getAdditionalexpense());
            table.setVehicleowner(body.getVehicleowner().equals("Y")?true:false);
            table.setTypevehicle(body.getTypevehicle());

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
