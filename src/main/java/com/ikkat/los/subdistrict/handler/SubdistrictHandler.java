package com.ikkat.los.subdistrict.handler;

import com.ikkat.los.subdistrict.entity.SubdistrictData;
import com.ikkat.los.subdistrict.mapper.GetSubDistrictData;
import com.ikkat.los.subdistrict.service.SubDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubdistrictHandler implements SubDistrictService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SubdistrictData getId(String id) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetSubDistrictData().schema());
        sqlBuilder.append(" where data.idregencies = ?  ");
        final Object[] queryParameters = new Object[] {id};
        List<SubdistrictData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetSubDistrictData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        SubdistrictData data = new SubdistrictData();
        data.setIdsubdistrict("");
        data.setIddistrict("");
        data.setNamesubdistrict("");
        data.setKodepos("");
        data.setKecamatan("");
        return data;
    }
}
