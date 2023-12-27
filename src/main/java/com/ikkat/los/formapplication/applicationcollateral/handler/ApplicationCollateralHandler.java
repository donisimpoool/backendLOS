package com.ikkat.los.formapplication.applicationcollateral.handler;

import com.ikkat.los.formapplication.applicationbank.mapper.GetApplicationBankData;
import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateral;
import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralData;
import com.ikkat.los.formapplication.applicationcollateral.entity.BodyApplicationCollateral;
import com.ikkat.los.formapplication.applicationcollateral.mapper.GetApplicationCollateralData;
import com.ikkat.los.formapplication.applicationcollateral.repo.ApplicationCollateralRepo;
import com.ikkat.los.formapplication.applicationcollateral.service.ApplicationCollateralService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationCollateralHandler implements ApplicationCollateralService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationCollateralRepo repository;

    @Override
    public List<ApplicationCollateralData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralData(), queryParameters);
    }

    @Override
    public ApplicationCollateralData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralData().schema());
        sqlBuilder.append(" where data.idcompany = ?  and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationCollateralData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationCollateralData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralData().schema());
        sqlBuilder.append(" where data.idcompany = ?  and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateral body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try {
            ApplicationCollateral table = new ApplicationCollateral();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setCollateral(body.getCollateral());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationCollateral body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try {
            ApplicationCollateral table = repository.getById(id);
            table.setCollateral(body.getCollateral());
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
