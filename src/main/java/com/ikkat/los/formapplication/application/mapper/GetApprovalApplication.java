package com.ikkat.los.formapplication.application.mapper;

import com.ikkat.los.formapplication.application.entity.ApplicationApprovalData;
import com.ikkat.los.formapplication.application.entity.ApplicationData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApprovalApplication implements RowMapper<ApplicationApprovalData> {
    private String schemaSql;

    public GetApprovalApplication() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.status as status, data.dateform as dateform, ");
        sqlBuilder.append("personal.names as personalnames, ");
        sqlBuilder.append("loan.amount as loanamount, loanprod.loan_name as loan_name, loanprod.loan_product_id as loan_product_id ");
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
    public ApplicationApprovalData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String status = rs.getString("status");
        final Date dateform = rs.getDate("dateform");
        final String personalnames = rs.getString("personalnames");
        final Double loanamount = rs.getDouble("loanamount");
        final String loan_product_id = rs.getString("loan_product_id");
        final String loan_name = rs.getString("loan_name");

        ApplicationApprovalData data = new ApplicationApprovalData();
        data.setId(id);
        data.setAmountloan(loanamount);
        data.setCreatedateapplication(dateform);
        data.setCreatedateapplicationmonth(dateform);
        data.setDistrictname("");
        data.setFullname(personalnames);
        data.setListdoc(new String[0]);
        data.setLoanid(loan_product_id);
        data.setLoannameproduct(loan_name);
        data.setProvincename("");
        data.setRegenciesname("");
        data.setStatus(status);
        return data;
    }
}
