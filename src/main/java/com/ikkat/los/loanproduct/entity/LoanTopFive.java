package com.ikkat.los.loanproduct.entity;

public class LoanTopFive {
    private Long loanid;
    private String loanname;
    private String loandescription;
    private int jumlahloan;

    public Long getLoanid() {
        return loanid;
    }

    public void setLoanid(Long loanid) {
        this.loanid = loanid;
    }

    public String getLoanname() {
        return loanname;
    }

    public void setLoanname(String loanname) {
        this.loanname = loanname;
    }

    public String getLoandescription() {
        return loandescription;
    }

    public void setLoandescription(String loandescription) {
        this.loandescription = loandescription;
    }

    public int getJumlahloan() {
        return jumlahloan;
    }

    public void setJumlahloan(int jumlahloan) {
        this.jumlahloan = jumlahloan;
    }
}
