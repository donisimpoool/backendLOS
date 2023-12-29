package com.ikkat.los.formapplication.application.entity;

import com.ikkat.los.formapplication.applicationaddress.entity.BodyApplicationAddress;
import com.ikkat.los.formapplication.applicationbank.entity.BodyApplicationBank;
import com.ikkat.los.formapplication.applicationbusiness.entity.BodyFormApplicationBusiness;
import com.ikkat.los.formapplication.applicationcollateral.entity.BodyApplicationCollateral;
import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.BodyApplicationCollateralDeposit;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.BodyApplicationCollateralRealEstate;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.BodyApplicationCollateralVehicle;
import com.ikkat.los.formapplication.applicationfamily.entity.BodyApplicationFamily;
import com.ikkat.los.formapplication.applicationfinancial.entity.BodyApplicationFinancial;
import com.ikkat.los.formapplication.applicationloan.entity.BodyApplicationLoan;
import com.ikkat.los.formapplication.applicationpersonal.entity.BodyApplicationPersonal;

public class BodyAllApplication {
    private BodyApplication application;

    private BodyApplicationPersonal applicationpersonal;
    private BodyApplicationLoan applicationloan;
    private BodyApplicationAddress applicationaddress;
    private BodyApplicationFamily applicationfamily;
    private BodyFormApplicationBusiness applicationbusiness;
    private BodyApplicationFinancial applicationfinancial;
    private BodyApplicationBank applicationbank;
    private BodyApplicationCollateral applicationcollateral;
    private BodyApplicationCollateralRealEstate applicationCollateralRealEstate;
    private BodyApplicationCollateralVehicle applicationCollateralVehicle;
    private BodyApplicationCollateralDeposit applicationCollateralDeposit;

    public BodyApplicationPersonal getApplicationpersonal() {
        return applicationpersonal;
    }

    public void setApplicationpersonal(BodyApplicationPersonal applicationpersonal) {
        this.applicationpersonal = applicationpersonal;
    }

    public BodyApplication getApplication() {
        return application;
    }

    public void setApplication(BodyApplication application) {
        this.application = application;
    }

    public BodyApplicationLoan getApplicationloan() {
        return applicationloan;
    }

    public void setApplicationloan(BodyApplicationLoan applicationloan) {
        this.applicationloan = applicationloan;
    }

    public BodyApplicationAddress getApplicationaddress() {
        return applicationaddress;
    }

    public void setApplicationaddress(BodyApplicationAddress applicationaddress) {
        this.applicationaddress = applicationaddress;
    }

    public BodyApplicationFamily getApplicationfamily() {
        return applicationfamily;
    }

    public void setApplicationfamily(BodyApplicationFamily applicationfamily) {
        this.applicationfamily = applicationfamily;
    }

    public BodyFormApplicationBusiness getApplicationbusiness() {
        return applicationbusiness;
    }

    public void setApplicationbusiness(BodyFormApplicationBusiness applicationbusiness) {
        this.applicationbusiness = applicationbusiness;
    }

    public BodyApplicationFinancial getApplicationfinancial() {
        return applicationfinancial;
    }

    public void setApplicationfinancial(BodyApplicationFinancial applicationfinancial) {
        this.applicationfinancial = applicationfinancial;
    }

    public BodyApplicationBank getApplicationbank() {
        return applicationbank;
    }

    public void setApplicationbank(BodyApplicationBank applicationbank) {
        this.applicationbank = applicationbank;
    }

    public BodyApplicationCollateral getApplicationcollateral() {
        return applicationcollateral;
    }

    public void setApplicationcollateral(BodyApplicationCollateral applicationcollateral) {
        this.applicationcollateral = applicationcollateral;
    }

    public BodyApplicationCollateralRealEstate getApplicationCollateralRealEstate() {
        return applicationCollateralRealEstate;
    }

    public void setApplicationCollateralRealEstate(BodyApplicationCollateralRealEstate applicationCollateralRealEstate) {
        this.applicationCollateralRealEstate = applicationCollateralRealEstate;
    }

    public BodyApplicationCollateralVehicle getApplicationCollateralVehicle() {
        return applicationCollateralVehicle;
    }

    public void setApplicationCollateralVehicle(BodyApplicationCollateralVehicle applicationCollateralVehicle) {
        this.applicationCollateralVehicle = applicationCollateralVehicle;
    }

    public BodyApplicationCollateralDeposit getApplicationCollateralDeposit() {
        return applicationCollateralDeposit;
    }

    public void setApplicationCollateralDeposit(BodyApplicationCollateralDeposit applicationCollateralDeposit) {
        this.applicationCollateralDeposit = applicationCollateralDeposit;
    }
}
