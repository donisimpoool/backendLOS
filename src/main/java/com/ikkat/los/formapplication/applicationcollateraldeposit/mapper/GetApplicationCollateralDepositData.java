package com.ikkat.los.formapplication.applicationcollateraldeposit.mapper;

import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralData;
import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDepositData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationCollateralDepositData implements RowMapper<ApplicationCollateralDepositData> {
    private String schemaSql;

    public GetApplicationCollateralDepositData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.bankid as bankid, data.amount as amount, ");
        sqlBuilder.append("data.currency as currency, data.accountnumber as accountnumber, data.duedate as duedate ");
        sqlBuilder.append("from formapplication_collateral_deposit as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationCollateralDepositData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String bankid = rs.getString("bankid");
        final Double amount = rs.getDouble("amount");
        final String currency = rs.getString("currency");
        final String accountnumber = rs.getString("accountnumber");
        final Date duedate = rs.getDate("duedate");

        ApplicationCollateralDepositData data = new ApplicationCollateralDepositData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setBankid(bankid);
        data.setAmount(amount);
        data.setCurrency(currency);
        data.setAccountnumber(accountnumber);
        data.setDuedate(duedate);
        return data;
    }
}
