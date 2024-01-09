package com.ikkat.los.loanproduct.mapper;

import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScoreData;
import com.ikkat.los.loanproduct.entity.LoanTopFive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLoanProductTopFive implements RowMapper<LoanTopFive> {
    private String schemaSql;

    public GetLoanProductTopFive() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.loan_product_id as id, data.loan_description as loan_description, data.loan_name as loan_name, count(appLoan.idapplication) as jumlah_loan ");
        sqlBuilder.append("from m_loan_product as data ");
        sqlBuilder.append("left join formapplication_loan as appLoan on appLoan.loanproductid = data.loan_product_id ");
        sqlBuilder.append("left join formapplication as app on app.id = appLoan.idapplication ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }
    @Override
    public LoanTopFive mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String loan_description = rs.getString("loan_description");
        final String loan_name = rs.getString("loan_name");
        final int jumlah_loan = rs.getInt("jumlah_loan");

        LoanTopFive data = new LoanTopFive();
        data.setLoanid(id);
        data.setJumlahloan(jumlah_loan);
        data.setLoanname(loan_name);
        data.setLoandescription(loan_description);
        return data;
    }
}
