package com.ikkat.los.dashboard.handler;

import com.ikkat.los.dashboard.entity.DataDashboard;
import com.ikkat.los.dashboard.entity.DoghnutChartData;
import com.ikkat.los.dashboard.entity.GraphBarByMonths;
import com.ikkat.los.dashboard.entity.GraphData;
import com.ikkat.los.dashboard.service.DashboardService;
import com.ikkat.los.formapplication.application.service.FormApplicationService;
import com.ikkat.los.loanproduct.entity.BodyLoanDashboard;
import com.ikkat.los.loanproduct.entity.LoanRangeSize;
import com.ikkat.los.loanproduct.entity.LoanTopFive;
import com.ikkat.los.loanproduct.service.LoanProdutsService;
import com.ikkat.los.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class DashboardHandler implements DashboardService {
    @Autowired
    private LoanProdutsService loanProdutsService;
    @Autowired
    private FormApplicationService applicationService;

    @Override
    public DataDashboard getData(Long idcompany, BodyLoanDashboard body) {
        List<LoanTopFive> listtopfive = loanProdutsService.getListLoanDashboardTopFive(idcompany,body);
        List<LoanRangeSize> listrangesize = loanProdutsService.getListLoanDashboardRangeSize(idcompany,body);
        DataDashboard data = new DataDashboard();
        data.setListrangesize(listrangesize);
        data.setListtopfive(listtopfive);
        return data;
    }

    @Override
    public GraphData getDataGraph(Long idcompany) {
        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            List<GraphBarByMonths> list = new ArrayList<GraphBarByMonths>();
            for (int month = 1; month <= 12; month++) {
                String strmonth = String.valueOf(month);
                if (month < 10) {
                    strmonth = "0" + String.valueOf(month);
                }
                String strfrom = year + "-" + strmonth + "-01";
                String strthru = year + "-" + strmonth + "-" + Utils.getCurrentMaxDate(year, month - 1, 1);

                Long appAll = applicationService.getCountApplicant(idcompany, strfrom, strthru, "");
                Long appApprove = applicationService.getCountApplicant(idcompany, strfrom, strthru, "A");
                Long appUnderwriting = applicationService.getCountApplicant(idcompany, strfrom, strthru, "U");

                GraphBarByMonths graphs = new GraphBarByMonths();
                graphs.setMonth(Utils.namabulan(month));
                graphs.setJlmapllicant(appAll);
                graphs.setJlmapllicantapprove(appApprove);
                graphs.setJlmapllicantpending(appUnderwriting);
                list.add(graphs);
            }


            String strfrom = year + "-01" + "-01";
            String strthru = year + "-12" + "-31";
            Long appAll = applicationService.getCountApplicant(idcompany, strfrom, strthru, "");
            Long appApprove = applicationService.getCountApplicant(idcompany, strfrom, strthru, "A");
            Long appUnderwriting = applicationService.getCountApplicant(idcompany, strfrom, strthru, "U");

            DoghnutChartData data = new DoghnutChartData();
            data.setJmlapplied(appAll);
            data.setJmlapprove(appApprove);
            data.setJmlpending(appUnderwriting);

            GraphData grp = new GraphData();
            grp.setDonuts(data);
            grp.setGraph(list);
            return grp;
        }catch (Exception e) {
            Class<?> enclosingClass = getClass().getEnclosingClass();
            String className = "";
            if (enclosingClass != null) {
                className = enclosingClass.getName();
            } else {
                className = getClass().getName();
            }
            System.out.println("Error "+className+" : "+e.getMessage());
        }

        return null;
    }
}
