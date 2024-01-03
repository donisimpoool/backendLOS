package com.ikkat.los.province.handler;

import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.province.mapper.GetProvinceData;
import com.ikkat.los.province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceHandler implements ProvinceService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProvinceData getId(String id) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetProvinceData().schema());
        sqlBuilder.append(" where data.location_code = ?  ");
        final Object[] queryParameters = new Object[] {id};
        List<ProvinceData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetProvinceData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        ProvinceData data = new ProvinceData();
        data.setLocationCode("");
        data.setLocationName("");
        data.setId_simpool("");
        return data;
    }
}
