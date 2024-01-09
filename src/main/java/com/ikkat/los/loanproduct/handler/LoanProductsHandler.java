package com.ikkat.los.loanproduct.handler;

import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.formapplication.application.service.FormApplicationService;
import com.ikkat.los.loanproduct.entity.BodyLoanDashboard;
import com.ikkat.los.loanproduct.entity.LoanRangeSize;
import com.ikkat.los.loanproduct.entity.LoanTopFive;
import com.ikkat.los.loanproduct.mapper.GetLoanProductTopFive;
import com.ikkat.los.loanproduct.mapper.GetLoanRangeSize;
import com.ikkat.los.loanproduct.service.LoanProdutsService;
import com.ikkat.los.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoanProductsHandler implements LoanProdutsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FormApplicationService applicationService;

    @Override
    public List<LoanTopFive> getListLoanDashboardTopFive(Long idcompany, BodyLoanDashboard body) {
        Date thru = new Date();
        String thrudate = Utils.DateToString(thru, DateFormatEnum.FORMAT_DATE.value());
//        thru = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(thru.getTime());
        cal.add(Calendar.MONTH, -body.getBulan());

        Date from = cal.getTime();
        String strFromdate = Utils.DateToString(from, DateFormatEnum.FORMAT_DATE.value());
//        from = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetLoanProductTopFive().schema());
        sqlBuilder.append(" where data.idcompany = ? and app.dateform >= '"+strFromdate+"' and app.dateform <= '"+thrudate+"'  ");
        sqlBuilder.append(" GROUP BY data.loan_product_id  ");
        sqlBuilder.append(" order by jumlah_loan DESC limit 5  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetLoanProductTopFive(), queryParameters);
    }

    @Override
    public List<LoanRangeSize> getListLoanDashboardRangeSize(Long idcompany, BodyLoanDashboard body) {
        Date thru = new Date();
        String thrudate = Utils.DateToString(thru, DateFormatEnum.FORMAT_DATE.value());
//        thru = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(thru.getTime());
        cal.add(Calendar.MONTH, -body.getBulan());

        Date from = cal.getTime();
        String strFromdate = Utils.DateToString(from, DateFormatEnum.FORMAT_DATE.value());
//        from = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

        Long appAll = applicationService.getCountApplicant(idcompany,strFromdate,thrudate,"");
        Long appApprove = applicationService.getCountApplicant(idcompany,strFromdate,thrudate,"A");
        Long appUnderwriting = applicationService.getCountApplicant(idcompany,strFromdate,thrudate,"U");

        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetLoanRangeSize(appAll,appApprove,appUnderwriting).schema());
        sqlBuilder.append(" where data.idcompany = ? and app.dateform >= '"+strFromdate+"' and app.dateform <= '"+thrudate+"'  ");
        sqlBuilder.append(" GROUP BY data.loan_product_id  ");
        sqlBuilder.append(" order by jumlah_loan DESC ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetLoanRangeSize(appAll,appApprove,appUnderwriting), queryParameters);
    }
}
