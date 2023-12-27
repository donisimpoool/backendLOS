package com.ikkat.los.formapplication.applicationcollateralrealestate.mapper;

import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDepositData;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationCollateralRealEstateData implements RowMapper<ApplicationCollateralRealEstateData> {
    private String schemaSql;

    public GetApplicationCollateralRealEstateData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.typerealestate as typerealestate, data.conditions as conditions, ");
        sqlBuilder.append("data.years as years, data.rooms as rooms, data.address as address, data.provinceid as provinceid, ");
        sqlBuilder.append("data.regenciesid as regenciesid, data.districtid as districtid, data.sizes as sizes, data.proofofownership as proofofownership ");
        sqlBuilder.append("from formapplication_collateral_real_estate as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationCollateralRealEstateData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String typerealestate = rs.getString("typerealestate");
        final String conditions = rs.getString("conditions");
        final int years = rs.getInt("years");
        final int rooms = rs.getInt("rooms");
        final String address = rs.getString("address");
        final String provinceid = rs.getString("provinceid");
        final String regenciesid = rs.getString("regenciesid");
        final String districtid = rs.getString("districtid");
        final String sizes = rs.getString("sizes");
        final String proofofownership = rs.getString("proofofownership");

        ApplicationCollateralRealEstateData data = new ApplicationCollateralRealEstateData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setTyperealestate(typerealestate);
        data.setConditions(conditions);
        data.setYears(years);
        data.setRooms(rooms);
        data.setAddress(address);
        data.setProvinceid(provinceid);
        data.setRegenciesid(regenciesid);
        data.setDistrictid(districtid);
        data.setSizes(sizes);
        data.setProofofownership(proofofownership);

        return data;
    }
}
