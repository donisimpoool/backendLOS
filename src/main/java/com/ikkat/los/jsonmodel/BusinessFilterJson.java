package com.ikkat.los.jsonmodel;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.entity.BusinessFilterConditionsPK;
import com.ikkat.los.entity.BusinessFilterEntity;
import com.ikkat.los.utils.Utils;

import io.swagger.annotations.ApiModelProperty;

public class BusinessFilterJson {
//	@ApiModelProperty(value = "Fill this entry on updates. On Create new business filter, leave this value out")
//	@JsonProperty(value = "id")
//	private Long id;
//	
//	@ApiModelProperty(value = "Name of business filter. This will be referred to in system configuration. Must be unique throughout all filters")
//	@JsonProperty(value = "name")
//    private String name;
//	
//	@ApiModelProperty(required = false)
//    private String description;
//    
//    @ApiModelProperty(value = "Response only. Don't enter this value when creating / updating")
//    @JsonProperty(value = "lastUpdated")
//    private String lastUpdated;
//    
//    @ApiModelProperty(value = "Reserved, do not use", hidden = true)
//    @JsonProperty(value = "className")
//    private String className;
//    
//    @JsonProperty(value = "conditions")
//    private List<BusinessFilterConditionsJson> conditions;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getLastUpdated() {
//		return lastUpdated;
//	}
//
//	public void setLastUpdated(String lastUpdated) {
//		this.lastUpdated = lastUpdated;
//	}
//
//	public String getClassName() {
//		return className;
//	}
//
//	public void setClassName(String className) {
//		this.className = className;
//	}
//
//	public List<BusinessFilterConditionsJson> getConditions() {
//		return conditions;
//	}
//
//	public void setConditions(List<BusinessFilterConditionsJson> conditions) {
//		this.conditions = conditions;
//	}
//	
//	
//	public HashMap<String, Object> getBusinessFilter() {
//		HashMap<String, Object> hash = new HashMap<>();
//		BusinessFilterEntity bf = new BusinessFilterEntity();
//		bf.setId(this.id);
//		bf.setName(this.name);
//		bf.setDescription(this.description);
//		bf.setLastUpdated(Utils.stringToZonedDateTime(this.lastUpdated));
//		bf.setClassName(this.className);
//		
//		List<BusinessFilterConditionsEntity> listcondition = new ArrayList<>();
//		if(this.conditions.size() > 0) {
//			for(BusinessFilterConditionsJson val : this.conditions) {
//				BusinessFilterConditionsPK pk = new BusinessFilterConditionsPK();
//				pk.setBfId(this.id);
//				pk.setFilterId(val.getFilterId());
//				
//				BusinessFilterConditionsEntity condEntity = new BusinessFilterConditionsEntity();
//				condEntity.setPk(pk);
//				condEntity.setFilterAction(val.getFilterAction());
//				condEntity.setFilterConditional(val.getFilterConditional());
//				condEntity.setFilterDesc(val.getFilterDesc());
//				condEntity.setFilterName(val.getFilterName());
//				condEntity.setFilterPrio(val.getFilterPrio());
//				condEntity.setIsMandatory(val.getIsMandatory());
//				condEntity.setLastUpdated(Utils.stringToZonedDateTime(val.getLastUpdated()));
//				listcondition.add(condEntity);
//				
//			}
//		}
//		hash.put("businessfilter", bf);
//		hash.put("conditions", listcondition);
//		return hash;
//	}
}
