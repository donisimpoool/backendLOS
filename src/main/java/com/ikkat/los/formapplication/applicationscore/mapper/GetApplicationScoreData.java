package com.ikkat.los.formapplication.applicationscore.mapper;

import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancialData;
import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScoreData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationScoreData implements RowMapper<ApplicationScoreData> {
    private String schemaSql;

    public GetApplicationScoreData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.propertypossession as propertypossession, data.numberofdependant as numberofdependant, ");
        sqlBuilder.append("data.gender as gender, data.locations as locations, data.liveownershipstatus as liveownershipstatus, data.vehicleowner as vehicleowner, ");
        sqlBuilder.append("data.maritalstatus as maritalstatus, data.companysize as companysize, data.creditcardowner as creditcardowner, data.debtincomeratio as debtincomeratio, ");
        sqlBuilder.append("data.industrysector as industrysector, data.education as education, data.incometype as incometype, data.age as age, ");
        sqlBuilder.append("data.durationwork as durationwork, data.jobtittle as jobtittle, data.positions as positions ");
        sqlBuilder.append("from formapplication_score as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationScoreData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final int propertypossession = rs.getInt("propertypossession");
        final int numberofdependant = rs.getInt("numberofdependant");
        final int gender = rs.getInt("gender");
        final int locations = rs.getInt("locations");
        final int liveownershipstatus = rs.getInt("liveownershipstatus");
        final int vehicleowner = rs.getInt("vehicleowner");
        final int maritalstatus = rs.getInt("maritalstatus");
        final int companysize = rs.getInt("companysize");
        final int creditcardowner = rs.getInt("creditcardowner");
        final int debtincomeratio = rs.getInt("debtincomeratio");
        final int industrysector = rs.getInt("industrysector");
        final int education = rs.getInt("education");
        final int incometype = rs.getInt("incometype");
        final int age = rs.getInt("age");
        final int durationwork = rs.getInt("durationwork");
        final int jobtittle = rs.getInt("jobtittle");
        final int positions = rs.getInt("positions");

        ApplicationScoreData data = new ApplicationScoreData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setPropertypossession(propertypossession);
        data.setNumberofdependant(numberofdependant);
        data.setGender(gender);
        data.setLocations(locations);
        data.setLiveownershipstatus(liveownershipstatus);
        data.setVehicleowner(vehicleowner);
        data.setMaritalstatus(maritalstatus);
        data.setCompanysize(companysize);
        data.setCreditcardowner(creditcardowner);
        data.setDebtincomeratio(debtincomeratio);
        data.setIndustrysector(industrysector);
        data.setEducation(education);
        data.setIncometype(incometype);
        data.setAge(age);
        data.setDurationwork(durationwork);
        data.setJobtittle(jobtittle);
        data.setPositions(positions);
        return data;
    }
}
