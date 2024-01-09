package com.ikkat.los.loanproduct.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_loan_product", schema = "public")
public class LoanProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="m_loan_product_id_seq")
    private Long loan_product_id;
    private Long idcompany;
    private String loan_description;
    private String loan_name;
    private boolean has_collateral;
    private Double minamount;
    private Double maxamount;
    private int mintenor;
    private int maxtenor;
    private String filterid_h;
    private int maxreject;
    private int defaulttenor;
    private Double defaultamount;
    private String isactive;
    private String externalid;
    private String renewalstatus;
    private String orientationusage;
    private String debtorcategory;
    private String financingcode;
    private String traidcode;
    private String interestrateperperiod;
    private String interesttype;
    private String amortizationtype;
    private String interestcalculationperiodtype;
    private String transactionprocessingstrategyid;
    private String loanpurposeid;
    private String economisector;
    private String economisectordetail;
    private String repaymentevery;
    private String repaymentfrequencytype;

    public Long getLoan_product_id() {
        return loan_product_id;
    }

    public void setLoan_product_id(Long loan_product_id) {
        this.loan_product_id = loan_product_id;
    }

    public Long getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Long idcompany) {
        this.idcompany = idcompany;
    }

    public String getLoan_description() {
        return loan_description;
    }

    public void setLoan_description(String loan_description) {
        this.loan_description = loan_description;
    }

    public String getLoan_name() {
        return loan_name;
    }

    public void setLoan_name(String loan_name) {
        this.loan_name = loan_name;
    }

    public boolean isHas_collateral() {
        return has_collateral;
    }

    public void setHas_collateral(boolean has_collateral) {
        this.has_collateral = has_collateral;
    }

    public Double getMinamount() {
        return minamount;
    }

    public void setMinamount(Double minamount) {
        this.minamount = minamount;
    }

    public Double getMaxamount() {
        return maxamount;
    }

    public void setMaxamount(Double maxamount) {
        this.maxamount = maxamount;
    }

    public int getMintenor() {
        return mintenor;
    }

    public void setMintenor(int mintenor) {
        this.mintenor = mintenor;
    }

    public int getMaxtenor() {
        return maxtenor;
    }

    public void setMaxtenor(int maxtenor) {
        this.maxtenor = maxtenor;
    }

    public String getFilterid_h() {
        return filterid_h;
    }

    public void setFilterid_h(String filterid_h) {
        this.filterid_h = filterid_h;
    }

    public int getMaxreject() {
        return maxreject;
    }

    public void setMaxreject(int maxreject) {
        this.maxreject = maxreject;
    }

    public int getDefaulttenor() {
        return defaulttenor;
    }

    public void setDefaulttenor(int defaulttenor) {
        this.defaulttenor = defaulttenor;
    }

    public Double getDefaultamount() {
        return defaultamount;
    }

    public void setDefaultamount(Double defaultamount) {
        this.defaultamount = defaultamount;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getExternalid() {
        return externalid;
    }

    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    public String getRenewalstatus() {
        return renewalstatus;
    }

    public void setRenewalstatus(String renewalstatus) {
        this.renewalstatus = renewalstatus;
    }

    public String getOrientationusage() {
        return orientationusage;
    }

    public void setOrientationusage(String orientationusage) {
        this.orientationusage = orientationusage;
    }

    public String getDebtorcategory() {
        return debtorcategory;
    }

    public void setDebtorcategory(String debtorcategory) {
        this.debtorcategory = debtorcategory;
    }

    public String getFinancingcode() {
        return financingcode;
    }

    public void setFinancingcode(String financingcode) {
        this.financingcode = financingcode;
    }

    public String getTraidcode() {
        return traidcode;
    }

    public void setTraidcode(String traidcode) {
        this.traidcode = traidcode;
    }

    public String getInterestrateperperiod() {
        return interestrateperperiod;
    }

    public void setInterestrateperperiod(String interestrateperperiod) {
        this.interestrateperperiod = interestrateperperiod;
    }

    public String getInteresttype() {
        return interesttype;
    }

    public void setInteresttype(String interesttype) {
        this.interesttype = interesttype;
    }

    public String getAmortizationtype() {
        return amortizationtype;
    }

    public void setAmortizationtype(String amortizationtype) {
        this.amortizationtype = amortizationtype;
    }

    public String getInterestcalculationperiodtype() {
        return interestcalculationperiodtype;
    }

    public void setInterestcalculationperiodtype(String interestcalculationperiodtype) {
        this.interestcalculationperiodtype = interestcalculationperiodtype;
    }

    public String getTransactionprocessingstrategyid() {
        return transactionprocessingstrategyid;
    }

    public void setTransactionprocessingstrategyid(String transactionprocessingstrategyid) {
        this.transactionprocessingstrategyid = transactionprocessingstrategyid;
    }

    public String getLoanpurposeid() {
        return loanpurposeid;
    }

    public void setLoanpurposeid(String loanpurposeid) {
        this.loanpurposeid = loanpurposeid;
    }

    public String getEconomisector() {
        return economisector;
    }

    public void setEconomisector(String economisector) {
        this.economisector = economisector;
    }

    public String getEconomisectordetail() {
        return economisectordetail;
    }

    public void setEconomisectordetail(String economisectordetail) {
        this.economisectordetail = economisectordetail;
    }

    public String getRepaymentevery() {
        return repaymentevery;
    }

    public void setRepaymentevery(String repaymentevery) {
        this.repaymentevery = repaymentevery;
    }

    public String getRepaymentfrequencytype() {
        return repaymentfrequencytype;
    }

    public void setRepaymentfrequencytype(String repaymentfrequencytype) {
        this.repaymentfrequencytype = repaymentfrequencytype;
    }
}
