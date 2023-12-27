package com.ikkat.los.formapplication.applicationcollateralrealestate.handler;

import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstate;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateData;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.BodyApplicationCollateralRealEstate;
import com.ikkat.los.formapplication.applicationcollateralrealestate.mapper.GetApplicationCollateralRealEstateData;
import com.ikkat.los.formapplication.applicationcollateralrealestate.repo.ApplicationCollateralRealEstateRepo;
import com.ikkat.los.formapplication.applicationcollateralrealestate.service.ApplicationCollateralRealEstateService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationCollateralRealEstateHandler implements ApplicationCollateralRealEstateService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationCollateralRealEstateRepo repository;

    @Override
    public List<ApplicationCollateralRealEstateData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralRealEstateData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralRealEstateData(), queryParameters);
    }

    @Override
    public ApplicationCollateralRealEstateData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralRealEstateData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationCollateralRealEstateData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralRealEstateData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationCollateralRealEstateData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationCollateralRealEstateData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationCollateralRealEstateData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationCollateralRealEstate body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try {
            ApplicationCollateralRealEstate table = new ApplicationCollateralRealEstate();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setTyperealestate(body.getTyperealestate());
            table.setConditions(body.getConditions());
            table.setYears(body.getYears());
            table.setRooms(body.getRooms());
            table.setAddress(body.getAddress());
            table.setProvinceid(body.getProvinceid());
            table.setRegenciesid(body.getRegenciesid());
            table.setDistrictid(body.getDistrictid());
            table.setSizes(body.getSizes());
            table.setProofofownership(body.getProofofownership());
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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationCollateralRealEstate body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try {
            ApplicationCollateralRealEstate table = repository.getById(id);
            table.setTyperealestate(body.getTyperealestate());
            table.setConditions(body.getConditions());
            table.setYears(body.getYears());
            table.setRooms(body.getRooms());
            table.setAddress(body.getAddress());
            table.setProvinceid(body.getProvinceid());
            table.setRegenciesid(body.getRegenciesid());
            table.setDistrictid(body.getDistrictid());
            table.setSizes(body.getSizes());
            table.setProofofownership(body.getProofofownership());
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
