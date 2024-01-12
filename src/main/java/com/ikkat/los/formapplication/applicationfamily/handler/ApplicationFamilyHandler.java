package com.ikkat.los.formapplication.applicationfamily.handler;

import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocument;
import com.ikkat.los.formapplication.applicationdocument.mapper.GetApplicationDocumentData;
import com.ikkat.los.formapplication.applicationdocument.repo.FormApplicationDocumentRepo;
import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamily;
import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyData;
import com.ikkat.los.formapplication.applicationfamily.entity.BodyApplicationFamily;
import com.ikkat.los.formapplication.applicationfamily.mapper.GetApplicationFamilyData;
import com.ikkat.los.formapplication.applicationfamily.repo.FormApplicationFamilyRepo;
import com.ikkat.los.formapplication.applicationfamily.service.ApplicationFamilyService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationFamilyHandler implements ApplicationFamilyService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationFamilyRepo repository;

    @Override
    public List<ApplicationFamilyData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFamilyData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFamilyData(), queryParameters);
    }

    @Override
    public ApplicationFamilyData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFamilyData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationFamilyData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFamilyData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<ApplicationFamilyData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationFamilyData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ?  ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationFamilyData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationFamily body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationFamily table = new ApplicationFamily();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setContactemergency(body.getContactemergency());
            table.setAddressemergencycontact(body.getAddressemergencycontact());
            table.setMobileemergency(body.getMobileemergency());
            table.setMothername(body.getMothername());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationFamily body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationFamily table = repository.findById(id).get();
            table.setContactemergency(body.getContactemergency());
            table.setAddressemergencycontact(body.getAddressemergencycontact());
            table.setMobileemergency(body.getMobileemergency());
            table.setMothername(body.getMothername());

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
