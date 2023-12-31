package com.ikkat.los.formapplication.application.entity;

import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.BodyApplicationCollateralDeposit;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.BodyApplicationCollateralRealEstate;

public class Tets {
    private boolean isdraft;
    private BodyApplicationCollateralDeposit applicationCollateralDeposit;

    private BodyApplicationCollateralRealEstate applicationCollateralRealEstate;

    public BodyApplicationCollateralRealEstate getApplicationCollateralRealEstate() {
        return applicationCollateralRealEstate;
    }

    public void setApplicationCollateralRealEstate(BodyApplicationCollateralRealEstate applicationCollateralRealEstate) {
        this.applicationCollateralRealEstate = applicationCollateralRealEstate;
    }

    public BodyApplicationCollateralDeposit getApplicationCollateralDeposit() {
        return applicationCollateralDeposit;
    }

    public void setApplicationCollateralDeposit(BodyApplicationCollateralDeposit applicationCollateralDeposit) {
        this.applicationCollateralDeposit = applicationCollateralDeposit;
    }

    public boolean isIsdraft() {
        return isdraft;
    }

    public void setIsdraft(boolean isdraft) {
        this.isdraft = isdraft;
    }
}
