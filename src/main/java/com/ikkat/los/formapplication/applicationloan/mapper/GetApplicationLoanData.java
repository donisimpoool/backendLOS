package com.ikkat.los.formapplication.applicationloan.mapper;

import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancialData;
import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoanData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationLoanData implements RowMapper<ApplicationLoanData> {
    private String schemaSql;

    public GetApplicationLoanData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.loanproductid as loanproductid, data.purposeofloan as purposeofloan, ");
        sqlBuilder.append("data.tenor as tenor, data.amount as amount ");
        sqlBuilder.append("from formapplication_loan as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationLoanData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final Long loanproductid = rs.getLong("loanproductid");
        final String purposeofloan = rs.getString("purposeofloan");
        final int tenor = rs.getInt("tenor");
        final Double amount = rs.getDouble("amount");

        ApplicationLoanData data = new ApplicationLoanData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setLoanproductid(loanproductid);
        data.setPurposeofloan(purposeofloan);
        data.setTenor(tenor);
        data.setAmount(amount);
        return data;
    }
}
