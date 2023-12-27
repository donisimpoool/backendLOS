package com.ikkat.los.formapplication.applicationcollateralvehicle.mapper;

import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateData;
import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.ApplicationCollateralVehicleData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationCollateralVehicleData implements RowMapper<ApplicationCollateralVehicleData> {
    private String schemaSql;

    public GetApplicationCollateralVehicleData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.typevehicle as typevehicle, data.brand as brand, ");
        sqlBuilder.append("data.typetransmision as typetransmision, data.years as years, data.mileage as mileage, data.mileage as mileage ");
        sqlBuilder.append("from formapplication_collateral_vehicle as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationCollateralVehicleData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String typevehicle = rs.getString("typevehicle");
        final String brand = rs.getString("brand");
        final String typetransmision = rs.getString("typetransmision");
        final int years = rs.getInt("years");
        final String mileage = rs.getString("mileage");
        final String model = rs.getString("model");

        ApplicationCollateralVehicleData data = new ApplicationCollateralVehicleData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setTypevehicle(typevehicle);
        data.setBrand(brand);
        data.setTypetransmision(typetransmision);
        data.setYears(years);
        data.setMileage(mileage);
        data.setModel(model);
        return data;
    }
}
