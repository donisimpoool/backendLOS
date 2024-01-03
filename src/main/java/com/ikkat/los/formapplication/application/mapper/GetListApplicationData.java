package com.ikkat.los.formapplication.application.mapper;

import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.formapplication.application.entity.ApplicationListData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetListApplicationData implements RowMapper<ApplicationListData> {

    private String schemaSql;

    public GetListApplicationData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(5);
        sqlBuilder.append("data.id as id, data.status as status, data.dateform as dateform, ");
        sqlBuilder.append("personal.names as personalnames, ");
        sqlBuilder.append("loan.amount as loanamount, loanprod.loan_name as loan_name ");
        sqlBuilder.append("from formapplication as data ");
        sqlBuilder.append("left join formapplication_personal as personal on personal.idapplication = data.id ");
        sqlBuilder.append("left join formapplication_loan as loan on loan.idapplication = data.id ");
        sqlBuilder.append("left join m_loan_product as loanprod on CAST(loanprod.loan_product_id as INTEGER) = loan.loanproductid ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationListData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String status = rs.getString("status");
        final Date dateform = rs.getDate("dateform");
        final String personalnames = rs.getString("personalnames");
        final Double loanamount = rs.getDouble("loanamount");
        final String loan_name = rs.getString("loan_name");

        ApplicationListData data = new ApplicationListData();
        data.setId(id);
        data.setStatus(status);
        data.setDate(dateform);
        data.setPersonalName(personalnames);
        data.setLoanAmount(loanamount);
        data.setLoanName(loan_name);

        return data;
    }
}
