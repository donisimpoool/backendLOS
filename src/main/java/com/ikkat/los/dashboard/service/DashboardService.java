package com.ikkat.los.dashboard.service;

import com.ikkat.los.dashboard.entity.DataDashboard;
import com.ikkat.los.dashboard.entity.GraphData;
import com.ikkat.los.loanproduct.entity.BodyLoanDashboard;

public interface DashboardService {
    DataDashboard getData(Long idcompany, BodyLoanDashboard body);
    GraphData getDataGraph(Long idcompany);
}
