package com.ikkat.los.jsonmodel;

import java.time.ZonedDateTime;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.utils.Utils;

import io.swagger.annotations.ApiModelProperty;

public class BusinessFilterConditionsJson {
	private String field;
	private String operand;
	private String value;
	private String action;
	private String description;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOperand() {
		return operand;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BusinessFilterConditionsEntity getEntity() {
		BusinessFilterConditionsEntity entity = new BusinessFilterConditionsEntity();
		entity.setField(this.field);
		entity.setOperand(this.operand);
		entity.setValue(this.value);
		entity.setAction(this.action);
		entity.setDescription(this.description);
		return entity;
	}
	
//	@ApiModelProperty(value = "Fill this value if update. Leave out when trying to create")
//	private Long filterId;
//
//	@ApiModelProperty(value = "Name of business filter condition. Must be unique within same business filter")
//	private String filterName;
//
//	@ApiModelProperty(value = "when trying to update / insert, filterConditional must be of format: "
//			+ "$${characteristic-variable-name}. Notice "
//			+ "the double-dollar ($$)!! This is due to Jackson JSON Spring limitation. For example: "
//			+ "$${age} > 50 || $${age} < 25, $${education} == \"S1\". When reading from response,"
//			+ "this double-dollar will not exist. Seems like jackson used '$' character for something else,"
//			+ "and thus interpret that as function or replace?")
//	private String filterConditional;
//
//	@ApiModelProperty(value = "one of REFER|REJECT|PASSED")
//	private String filterAction;
//
//	@ApiModelProperty(value = "priority of filter. 1 = high, 99 = low")
//	private Long filterPrio;
//	private String filterDesc;
//
//	@ApiModelProperty(value = "Response only")
//	private String lastUpdated;
//	private Boolean isMandatory;
//	
//	public BusinessFilterConditionsJson(Long filterId, String filterName, String filterConditional, String filterAction,
//			Long filterPrio, String filterDesc, String lastUpdated, Boolean isMandatory) {
//		super();
//		this.filterId = filterId;
//		this.filterName = filterName;
//		this.filterConditional = filterConditional;
//		this.filterAction = filterAction;
//		this.filterPrio = filterPrio;
//		this.filterDesc = filterDesc;
//		this.lastUpdated = lastUpdated;
//		this.isMandatory = isMandatory;
//	}
//	public BusinessFilterConditionsJson(BusinessFilterConditionsEntity condition) {
//		if (condition != null) {
//			this.filterId = condition.getPk().getFilterId(); 
//			this.filterName = condition.getFilterName(); 
//			this.filterConditional = condition.getFilterConditional(); 
//			this.filterAction = condition.getFilterAction(); 
//			this.filterPrio = condition.getFilterPrio(); 
//			this.filterDesc = condition.getFilterDesc();
//			this.lastUpdated = Utils.zonedDateTimeToString(condition.getLastUpdated()); 
//			this.isMandatory = condition.getIsMandatory();
//		}
//	}
//	public BusinessFilterConditionsJson() {
//		super();
//	}
//	public Long getFilterId() {
//		return filterId;
//	}
//	public String getFilterName() {
//		return filterName;
//	}
//	public String getFilterConditional() {
//		return filterConditional;
//	}
//	public String getFilterAction() {
//		return filterAction;
//	}
//	public Long getFilterPrio() {
//		return filterPrio;
//	}
//	public String getFilterDesc() {
//		return filterDesc;
//	}
//	public String getLastUpdated() {
//		return lastUpdated;
//	}
//	public Boolean getIsMandatory() {
//		return isMandatory;
//	}
//	@Override
//	public String toString() {
//		return "BusinessFilterConditionsJson [filterId=" + filterId + ", filterName=" + filterName
//				+ ", filterConditional=" + filterConditional + ", filterAction=" + filterAction + ", filterPrio="
//				+ filterPrio + ", filterDesc=" + filterDesc + ", lastUpdated=" + lastUpdated + ", isMandatory="
//				+ isMandatory + "]";
//	}
}
