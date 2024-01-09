package com.ikkat.los.dashboard.entity;

import com.ikkat.los.loanproduct.entity.LoanRangeSize;
import com.ikkat.los.loanproduct.entity.LoanTopFive;

import java.util.List;

public class DataDashboard {
    private List<LoanTopFive> listtopfive;
    private List<LoanRangeSize> listrangesize;

    public List<LoanTopFive> getListtopfive() {
        return listtopfive;
    }

    public void setListtopfive(List<LoanTopFive> listtopfive) {
        this.listtopfive = listtopfive;
    }

    public List<LoanRangeSize> getListrangesize() {
        return listrangesize;
    }

    public void setListrangesize(List<LoanRangeSize> listrangesize) {
        this.listrangesize = listrangesize;
    }
}
