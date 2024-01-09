package com.ikkat.los.formapplication.application.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCountApplicantData implements RowMapper<Long> {
    private String schemaSql;

    public GetCountApplicantData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append(" count(data.id) as jumlahapplicant ");
        sqlBuilder.append("from formapplication as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long jumlahapplicant = rs.getLong("jumlahapplicant");
        return jumlahapplicant;
    }
}
