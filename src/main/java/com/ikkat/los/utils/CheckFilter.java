package com.ikkat.los.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterHeaderEntity;
import com.ikkat.los.enumeration.FilterFieldEnum;
import com.ikkat.los.enumeration.OperandEnum;
import com.ikkat.los.enumeration.StatusFilterEnum;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.service.FilterDetailService;
import com.ikkat.los.service.FilterHeaderService;



public class CheckFilter {
	
	
	public HashMap<String, Object> mapCheckingFilter(HashMap<String, Object> param){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String strfilterid = (String) param.get("filterid");
		
		ParamsRoulesScoreEntity paramsroules = (ParamsRoulesScoreEntity) param.get("paramsroules");
		FilterHeaderService headerservice = (FilterHeaderService) param.get("headerservice");
		FilterDetailService detailservice = (FilterDetailService) param.get("detailservice");
		Optional<FilterHeaderEntity> opHeader = headerservice.findById(strfilterid);
		boolean flag = false;
		String action = "";
		int maxreject = paramsroules.getMaxreject();
		int countreject = 0;
		int countrefer = 0;
		String ruleEnginecommentsReject = "";
		String ruleEnginecommentsRefer = "";
		if(opHeader.isPresent()) {
			FilterHeaderEntity header = opHeader.get();
			List<FilterDetailEntity> listdetail = detailservice.listdetailByHeaderid(strfilterid);
			if(listdetail.size() > 0) {
				for(FilterDetailEntity detail : listdetail ) {
					if(detail.getField().equals(FilterFieldEnum.AGE.value())) {
						flag = operandEquals(detail.getValue(), String.valueOf(paramsroules.getValuenumberage()), true);
					}else if(detail.getField().equals(FilterFieldEnum.GENDER.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValuegender(), false);
					}else if(detail.getField().equals(FilterFieldEnum.EDUCATION.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValueeducation(), false);
					}else if(detail.getField().equals(FilterFieldEnum.MARITALSTATUS.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValuemaritalstatus(), false);
					}else if(detail.getField().equals(FilterFieldEnum.CURRENTADDRESS.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValueprovinceid(), false);
						if(!flag) {
							flag = operandEquals(detail.getValue(), paramsroules.getRegenciesid(), false);
						}
					}else if(detail.getField().equals(FilterFieldEnum.HOUSEOWNERSHIP.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValueliveownershipstatus(), false);
					}else if(detail.getField().equals(FilterFieldEnum.NUMBEROFCHILDREN.value())) {
						flag = serachoperand(detail.getOperand(), new Double(detail.getValue()).doubleValue(), new Double(paramsroules.getValuenumberofdependant()).doubleValue());
					}else if(detail.getField().equals(FilterFieldEnum.NETINCOME.value())) {
						flag = serachoperand(detail.getOperand(), new Double(detail.getValue()).doubleValue(), paramsroules.getNetincome());
					}else if(detail.getField().equals(FilterFieldEnum.OWNCREDITCARD.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValuecreditcardowner(), false);
					}else if(detail.getField().equals(FilterFieldEnum.INCOMETYPE.value())) {
						flag = operandEquals(detail.getValue(), paramsroules.getValueincometype(), false);
					}
					
					if(flag) {
						action = detail.getAction();
						if(action.equals(StatusFilterEnum.REJECT.value())) {
							countreject++;
							ruleEnginecommentsReject += " -"+detail.getDescription();
//							break;
//							if(countreject >= maxreject) {
//								break;
//							}
						}else if(action.equals(StatusFilterEnum.REFER.value())) {
							countrefer++;
							ruleEnginecommentsRefer += " -"+detail.getDescription();
						}
						
						
					}
				}
			}
		}
		String ruleEnginecomments = "";
		action = "";
		if(countreject > 0) {
			action = StatusFilterEnum.REJECT.value();
			ruleEnginecomments = ruleEnginecommentsReject;
		}else if(countrefer > 0) {
			action = StatusFilterEnum.REFER.value();
			ruleEnginecomments = ruleEnginecommentsRefer;
		}
	
		map.put("flag", flag);
		map.put("action", action);
		map.put("ruleEnginecomments", ruleEnginecomments);
		return map;
	}
	
	private boolean serachoperand(String operand,double value,double valuedetail) {
		boolean flag = true;
		if(operand.equals(OperandEnum.EQUALS.value())) {
			flag = operandEquals(String.valueOf(value), String.valueOf(valuedetail), true);
		}else if(operand.equals(OperandEnum.GREATERTHAN.value())) {
			flag = operandGreaterThan(value, valuedetail);
		}else if(operand.equals(OperandEnum.GREATEREQUALSTHAN.value())) {
			flag = operandGreaterEqualsThan(value, valuedetail);
		}else if(operand.equals(OperandEnum.LOWERTHAN.value())) {
			flag = operandLowerThan(value, valuedetail);
		}else if(operand.equals(OperandEnum.LOWEREQUALSTHAN.value())) {
			flag = operandLowerEqualsThan(value, valuedetail);
		}
		return flag;
	}
	
	private boolean operandEquals(String value,String valuedetail,boolean isnumber) {
		boolean flag = false;
		if(isnumber) {
			if(new Double(value).doubleValue() == new Double(valuedetail).doubleValue()) {
				flag = true;
			}
		}else {
			if(value.equals(valuedetail)) {
				flag = true;
			}
		}
		return flag;
	}
	private boolean operandGreaterThan(double value,double valuedetail) {
		boolean flag = false;
		if(valuedetail > value) {
			flag = true;
		}
		return flag;
	}
	private boolean operandGreaterEqualsThan(double value,double valuedetail) {
		boolean flag = false;
		if(valuedetail >= value) {
			flag = true;
		}
		return flag;
	}
	private boolean operandLowerThan(double value,double valuedetail) {
		boolean flag = false;
		if(valuedetail < value) {
			flag = true;
		}
		return flag;
	}
	private boolean operandLowerEqualsThan(double value,double valuedetail) {
		boolean flag = false;
		if(valuedetail <= value) {
			flag = true;
		}
		return flag;
	}
}
