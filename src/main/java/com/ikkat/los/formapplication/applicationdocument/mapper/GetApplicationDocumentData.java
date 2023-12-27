package com.ikkat.los.formapplication.applicationdocument.mapper;

import com.ikkat.los.formapplication.applicationdocument.entity.ApplicationDocumentData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationDocumentData implements RowMapper<ApplicationDocumentData> {

    private String schemaSql;

    public GetApplicationDocumentData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.description as description, data.files as files ");
        sqlBuilder.append("from formapplication_document as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationDocumentData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String description = rs.getString("description");
        final String files = rs.getString("files");

        ApplicationDocumentData data = new ApplicationDocumentData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setDescription(description);
        data.setFiles(files);

        return data;
    }
}
