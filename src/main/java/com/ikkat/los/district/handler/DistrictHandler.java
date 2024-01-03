package com.ikkat.los.district.handler;

import com.ikkat.los.district.entity.DistrictData;
import com.ikkat.los.district.mapper.GetDistrictData;
import com.ikkat.los.district.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictHandler implements DistrictService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DistrictData getId(String id) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetDistrictData().schema());
        sqlBuilder.append(" where data.iddistrict = ?  ");
        final Object[] queryParameters = new Object[] {id};
        List<DistrictData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetDistrictData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        DistrictData data = new DistrictData();
        data.setIdregencies("");
        data.setIddistrict("");
        data.setNamedistrict("");

        return data;
    }
}
