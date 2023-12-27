package com.ikkat.los.formapplication.applicationcollateralvehicle.handler;

import com.ikkat.los.formapplication.applicationcollateralrealestate.mapper.GetApplicationCollateralRealEstateData;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.ApplicationCollateralVehicle;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.ApplicationCollateralVehicleData;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.BodyApplicationCollateralVehicle;
import com.ikkat.los.formapplication.applicationcollateralvehicle.mapper.GetApplicationCollateralVehicleData;
import com.ikkat.los.formapplication.applicationcollateralvehicle.repo.ApplicationCollateralVehicleRepo;
import com.ikkat.los.formapplication.applicationcollateralvehicle.service.ApplicationCollateralVehicleService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationCollateralVehicleHandler implements ApplicationCollateralVehicleService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationCollateralVehicleRepo repository;

    @Override
    public List<ApplicationCollateralVehicleData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralVehicleData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralVehicleData(), queryParameters);
    }

    @Override
    public ApplicationCollateralVehicleData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralVehicleData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationCollateralVehicleData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralVehicleData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationCollateralVehicleData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralVehicleData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralVehicleData(), queryParameters);

    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralVehicle body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationCollateralVehicle table = new ApplicationCollateralVehicle();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setTypevehicle(body.getTypevehicle());
            table.setBrand(body.getBrand());
            table.setTypetransmision(body.getTypetransmision());
            table.setYears(body.getYears());
            table.setMileage(body.getMileage());
            table.setModel(body.getModel());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationCollateralVehicle body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationCollateralVehicle table = repository.getById(id);
            table.setTypevehicle(body.getTypevehicle());
            table.setBrand(body.getBrand());
            table.setTypetransmision(body.getTypetransmision());
            table.setYears(body.getYears());
            table.setMileage(body.getMileage());
            table.setModel(body.getModel());
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
