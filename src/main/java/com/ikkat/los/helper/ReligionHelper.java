package com.ikkat.los.helper;

import java.util.HashMap;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ikkat.los.entity.ReligionEntity;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.service.ReligionService;

public class ReligionHelper {
	public static String insertReligionFromSimpool(HashMap<String, Object> mapParam) {
		String value = "";
		JSONObject jsonobj = (JSONObject) mapParam.get("jsonarray");
		ReligionService service = (ReligionService) mapParam.get("service");
		JSONArray jsonarray = (JSONArray) jsonobj.get("religionOption");
		for(int x=0; x < jsonarray.size(); x++) {
			JSONObject item = (JSONObject) jsonarray.get(x);
			Long id = (Long) item.get("id");
			String name = (String) item.get("name");
			
			Optional<ReligionEntity> optReligi = service.findById(id.toString());
			if(optReligi.isPresent()) {
				ReligionEntity religi = optReligi.get();
				religi.setName(name);
				service.update(id.toString(), religi);
			}else {
				ReligionEntity religi = new ReligionEntity();
				religi.setId(id.toString());
				religi.setName(name);
				religi.setIsactive("Y");
				service.create(religi);
			}
		}
		
		return value;
	}
}
