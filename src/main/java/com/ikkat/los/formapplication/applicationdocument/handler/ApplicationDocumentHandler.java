package com.ikkat.los.formapplication.applicationdocument.handler;

import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocument;
import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocumentData;
import com.ikkat.los.formapplication.applicationdocument.entity.BodyApplicationDocument;
import com.ikkat.los.formapplication.applicationdocument.mapper.GetApplicationDocumentData;
import com.ikkat.los.formapplication.applicationdocument.repo.FormApplicationDocumentRepo;
import com.ikkat.los.formapplication.applicationdocument.service.ApplicationDocumentService;
import com.ikkat.los.shared.ConstansCodeMessage;
import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.shared.ValidationDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationDocumentHandler implements ApplicationDocumentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationDocumentRepo repository;

    @Override
    public List<ApplicationDocumentData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationDocumentData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationDocumentData(), queryParameters);
    }

    @Override
    public ApplicationDocumentData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationDocumentData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.id = ? ");
        final Object[] queryParameters = new Object[] {idcompany,id};
        List<ApplicationDocumentData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationDocumentData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<ApplicationDocumentData> getByIdApplication(Long idapplication, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetApplicationDocumentData().schema());
        sqlBuilder.append(" where data.idcompany = ? and data.idapplication = ? ");
        final Object[] queryParameters = new Object[] {idcompany,idapplication};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetApplicationDocumentData(), queryParameters);
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationDocument body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationDocument table = new ApplicationDocument();
            table.setIdapplication(idapplication);
            table.setIdcompany(idcompany);
            table.setDescription(body.getDescription());
            table.setFiles(body.getFiles());

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
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyApplicationDocument body) {
        List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
        long idsave = 0;
        try{
            ApplicationDocument table = repository.getById(id);
            table.setDescription(body.getDescription());
            table.setFiles(body.getFiles());

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
