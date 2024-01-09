package com.ikkat.los.loanproduct.mapper;

import com.ikkat.los.loanproduct.entity.LoanRangeSize;
import com.ikkat.los.loanproduct.entity.LoanTopFive;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLoanRangeSize implements RowMapper<LoanRangeSize> {
    private String schemaSql;
    private Long appAll;
    private Long appApprove;
    private Long appUnderwriting;


    public GetLoanRangeSize(Long appAll,Long appApprove,Long appUnderwriting) {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.loan_product_id as id, data.loan_description as loan_description, data.loan_name as loan_name, SUM(appLoan.amount) as jumlah_loan ");
        sqlBuilder.append("from m_loan_product as data ");
        sqlBuilder.append("left join formapplication_loan as appLoan on appLoan.loanproductid = data.loan_product_id ");
        sqlBuilder.append("left join formapplication as app on app.id = appLoan.idapplication ");

        this.schemaSql = sqlBuilder.toString();
        this.appAll = appAll;
        this.appApprove = appApprove;
        this.appUnderwriting = appUnderwriting;
    }

    public String schema() {
        return this.schemaSql;
    }
    @Override
    public LoanRangeSize mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Long id = rs.getLong("id");
        final String loan_description = rs.getString("loan_description");
        final String loan_name = rs.getString("loan_name");
        final Double jumlah_loan = rs.getDouble("jumlah_loan");
//
        LoanRangeSize data = new LoanRangeSize();
        data.setLoanID(id.toString());
        data.setAmount(new BigDecimal(jumlah_loan));
        data.setLoanname(loan_name);
        data.setLoandesc(loan_description);
        data.setAppall(this.appAll);
        data.setAppapprove(this.appApprove);
        data.setAppunderwriting(this.appUnderwriting);
        return data;
    }
}
