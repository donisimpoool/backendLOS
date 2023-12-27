package com.ikkat.los.formapplication.applicationbank.mapper;

import com.ikkat.los.formapplication.applicationbank.entity.ApplicationBankData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationBankData implements RowMapper<ApplicationBankData> {
    private String schemaSql;

    public GetApplicationBankData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.bankid as bankid, data.accounttype as accounttype, ");
        sqlBuilder.append("data.accountnumber as accountnumber, data.iscreditcard as iscreditcard, data.bankcc as bankcc, data.numbercc as numbercc, ");
        sqlBuilder.append("data.typecredittcard as typecredittcard ");
        sqlBuilder.append("from formapplication_bank as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationBankData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String bankid = rs.getString("bankid");
        final String accounttype = rs.getString("accounttype");
        final String accountnumber = rs.getString("accountnumber");
        final boolean iscreditcard = rs.getBoolean("iscreditcard");
        final String bankcc = rs.getString("bankcc");
        final String numbercc = rs.getString("numbercc");
        final String typecredittcard = rs.getString("typecredittcard");

        ApplicationBankData data = new ApplicationBankData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setBankid(bankid);
        data.setAccounttype(accounttype);
        data.setAccountnumber(accountnumber);
        data.setIscreditcard(iscreditcard);
        data.setBankcc(bankcc);
        data.setNumbercc(numbercc);
        data.setTypecredittcard(typecredittcard);
        return data;
    }
}
