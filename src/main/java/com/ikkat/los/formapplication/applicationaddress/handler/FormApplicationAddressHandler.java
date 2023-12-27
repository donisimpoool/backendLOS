package com.ikkat.los.formapplication.applicationaddress.handler;

import com.ikkat.los.formapplication.application.entity.Application;
import com.ikkat.los.formapplication.application.repo.FormApplicationRepo;
import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddress;
import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddressData;
import com.ikkat.los.formapplication.applicationaddress.entity.BodyApplicationAddress;
import com.ikkat.los.formapplication.applicationaddress.mapper.GetDataApplicationAddress;
import com.ikkat.los.formapplication.applicationaddress.repo.FormApplicationAddressRepo;
import com.ikkat.los.formapplication.applicationaddress.service.FormApplicationAddressService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormApplicationAddressHandler implements FormApplicationAddressService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationAddressRepo repository;

    @Override
    public List<ApplicationAddressData> getListAll(Long idcompany) {

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplicationAddress().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplicationAddress(), queryParameters);
    }

    @Override
    public ApplicationAddressData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplicationAddress().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationAddressData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplicationAddress(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationAddressData> getByIdApplication(Long idapplication, Long idcompany) {

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDataApplicationAddress().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetDataApplicationAddress(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser,Long idapplication, BodyApplicationAddress body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationAddress table = new ApplicationAddress();
            table.setIdcompany(idcompany);
            table.setIdapplication(idapplication);
            table.setMainaddress(body.getMainaddress());
            table.setProvinceid(body.getProvinceid());
            table.setPostalcode(body.getPostalcode());
            table.setOwnershipstatus(body.getOwnershipstatus());
            table.setUsedforcollateral(body.getUsedforcollateral());
            table.setLiveinaddress(body.getLiveinaddress());
            table.setSecondaddress(body.getSecondaddress());
            table.setSecondprovinceid(body.getSecondprovinceid());
            table.setSecondpostalcode(body.getSecondpostalcode());
            table.setSecondownershipstatus(body.getSecondownershipstatus());
            table.setSecondusedforcollateral(body.getSecondusedforcollateral());
            table.setIdregencies(body.getIdregencies());
            table.setIddistrict(body.getIddistrict());
            table.setSecondidregencies(body.getSecondidregencies());
            table.setSecondiddistrict(body.getSecondiddistrict());
            table.setLocationaddress(body.getLocation());
            table.setRt(body.getRt());
            table.setRw(body.getRw());
            table.setVillagesid(body.getVillagesid());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationAddress body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationAddress table = repository.getById(id);
            table.setMainaddress(body.getMainaddress());
            table.setProvinceid(body.getProvinceid());
            table.setPostalcode(body.getPostalcode());
            table.setOwnershipstatus(body.getOwnershipstatus());
            table.setUsedforcollateral(body.getUsedforcollateral());
            table.setLiveinaddress(body.getLiveinaddress());
            table.setSecondaddress(body.getSecondaddress());
            table.setSecondprovinceid(body.getSecondprovinceid());
            table.setSecondpostalcode(body.getSecondpostalcode());
            table.setSecondownershipstatus(body.getSecondownershipstatus());
            table.setSecondusedforcollateral(body.getSecondusedforcollateral());
            table.setIdregencies(body.getIdregencies());
            table.setIddistrict(body.getIddistrict());
            table.setSecondidregencies(body.getSecondidregencies());
            table.setSecondiddistrict(body.getSecondiddistrict());
            table.setLocationaddress(body.getLocation());
            table.setRt(body.getRt());
            table.setRw(body.getRw());
            table.setVillagesid(body.getVillagesid());
            repository.saveAndFlush(table);
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
