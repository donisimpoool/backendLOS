package com.ikkat.los.helper;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.gson.Gson;
import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.entity.UrlEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.jsonmodel.CheckUpdateSimpoolJson;
import com.ikkat.los.jsonmodel.CustomerJson;
import com.ikkat.los.service.CustomerService;
import com.ikkat.los.service.ParamaterService;
import com.ikkat.los.service.ProvinceSimpoolService;
import com.ikkat.los.service.UrlService;
import com.ikkat.los.utils.CallApiSimpool;
import com.ikkat.los.utils.JsonHelper;
import com.ikkat.los.utils.Utils;

public class CustomerHelper {
	public static HashMap<String, Object> sendCustomerToSimpool(HashMap<String, Object> mapparam) throws ParseException, IOException{
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		UrlService service = (UrlService) mapparam.get("urlService");
		applicationEntity appjson = (applicationEntity) mapparam.get("appjson");
		ParamaterService paramservice = (ParamaterService) mapparam.get("paramservice");
		
		CheckUpdateSimpoolJson paramField = new CheckUpdateSimpoolJson();
		paramField.setDateofbirth(appjson.getPersonelapp().getDateofbirth().toInstant().toEpochMilli());
		paramField.setFullname(appjson.getPersonelapp().getName());
		paramField.setIdnumber(appjson.getPersonelapp().getIdnumber());
		
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		String userauth = paramservice.findById("userauth").get().getParamater();
		String passauth = paramservice.findById("passauth").get().getParamater();
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("paramsearch", paramField);
		param.put("userauth", userauth);
		param.put("passauth", passauth);
		param.put("urlService", service);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		HashMap<String, Object> findcustsimpool = findCustomerSimpool(param);
		List<CustomerEntity> list = (List<CustomerEntity>) findcustsimpool.get("list");
		String cfid = "";
		if(list.size() == 0) {
			Optional<UrlEntity> murl = service.findById("registercust");
			String url = murl.get().getUrl();
			CallApiSimpool apisimpool = new CallApiSimpool();
			Gson gson = new Gson();
			String simpoolprovinceid = "";
			String simpoolcityid = "";
			
			CustomerJson cust = new CustomerJson();
			cust.setLegalFormId("1");
			cust.setOfficeId("1");
			cust.setFullname(appjson.getPersonelapp().getName());
			cust.setTypeOfIdentityId("2307"); //2307 KTP
			cust.setMotherName(appjson.getFamilyapp().getMothername());
			cust.setAddressBasedOnIdentity(appjson.getAddressapp().getMainaddress());
			cust.setAddress(appjson.getAddressapp().getMainaddress());
			cust.setIdentityNumber(appjson.getPersonelapp().getIdnumber());
			cust.setMobileNo(appjson.getPersonelapp().getMobilephone().replace(" ",""));
			cust.setEmail(appjson.getPersonelapp().getEmail());
			cust.setSectorId("1000");
			cust.setPlaceOfBirth(appjson.getPersonelapp().getPlaceofbirth());
			cust.setReligion(appjson.getPersonelapp().getReligionid());
			cust.setCountryCodeValue("28");
			cust.setProvinceId(appjson.getAddressapp().getProvincemain().getId_simpool());
			cust.setCityId(appjson.getAddressapp().getRegenciesmain().getId_simpool());
			cust.setPostalCode(appjson.getAddressapp().getPostalcode());
			cust.setActive("true");
			cust.setFlagTaxCodeValue("Y");
			cust.setGenderCodeValue(appjson.getPersonelapp().getGender());
			cust.setMobileUser(appjson.getPersonelapp().getEmail());
			cust.setLocale("en");
			cust.setDateFormat(DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value());
			cust.setActivationDate(Utils.longDateToString(new java.util.Date().getTime(), DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value()));
			cust.setSubmittedOnDate(Utils.longDateToString(new java.util.Date().getTime(), DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value()));
			cust.setDateOfBirth(Utils.longDateToString(appjson.getPersonelapp().getDateofbirth().toInstant().toEpochMilli(), DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value()));
			cust.setSavingsProductId("");
			cust.setIdentityRt(appjson.getAddressapp().getRt());
			cust.setIdentityRw(appjson.getAddressapp().getRw());
			cust.setIdentitySubDistrict(appjson.getAddressapp().getDistrictmain().getNamedistrict());
			cust.setIdentityVillage(appjson.getAddressapp().getSubdistrictmain().getNamesubdistrict());
			cust.setTaxNumber(appjson.getPersonelapp().getTaxnumber());
			cust.setTaxName(appjson.getPersonelapp().getName());
			cust.setTaxAddress(appjson.getAddressapp().getMainaddress());
			cust.setReferralCode("SYSTEM");
			cust.setIdentityCountryCodeValue("IDN");
			cust.setIdentityProvinceId(appjson.getAddressapp().getProvincemain().getId_simpool());
			cust.setIdentityCityId(appjson.getAddressapp().getRegenciesmain().getId_simpool());
			cust.setIdentityPostalCode(appjson.getAddressapp().getPostalcode());
			
			String strCust = gson.toJson(cust);
			
			String filepath = paramservice.findById("image").get().getParamater();
			
			byte[] fileContent = FileUtils.readFileToByteArray(new File(filepath));
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			
			File file = new File(filepath);
			HashMap<String, Object> paramapi = new HashMap<String, Object>();
			
			MultiValueMap<String, Object> valuemap = new LinkedMultiValueMap<String, Object>();
			valuemap.add("data", strCust);
			valuemap.add("photo", new FileSystemResource(file));
			valuemap.add("idCard", new FileSystemResource(file));
			valuemap.add("signature", new FileSystemResource(file));
			valuemap.add("familyCard", new FileSystemResource(file));
			
			paramapi.put("formdata", valuemap);
			paramapi.put("url", url);
			paramapi.put("tenantid", tenantid);
			
			HashMap<String, Object> mapreturn = apisimpool.resultPostFormData(paramapi);
			int code = (Integer) mapreturn.get("code");
			String body = (String) mapreturn.get("body");
			
			if(code == 200) {
//				String body = (String) mapreturn.get("body");
				JSONObject jsonobj = (JSONObject) JsonHelper.ConvertStringToJson(body);
				Long lgcfid = (Long) jsonobj.get("clientId");
				cfid = lgcfid.toString();
			}
		}
		mapReturn.put("cfid", cfid);
		return mapReturn;
	}
	
	public static HashMap<String, Object> findCustomerSimpool(HashMap<String, Object> param) throws ParseException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		CheckUpdateSimpoolJson paramField = (CheckUpdateSimpoolJson) param.get("paramsearch");
		UrlService service = (UrlService) param.get("urlService");
		String tenantid = (String) param.get("tenantid");
		String authsimpool = (String) param.get("authsimpool");
		String userauth = (String) param.get("userauth");
		String passauth = (String) param.get("passauth");
		
		Optional<UrlEntity> murl = service.findById("checkduplicate");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value());
		String dateOfBirth = dateFormat.format(paramField.getDateofbirth()).replaceAll("-", "+");
		String fullname = paramField.getFullname().replaceAll(" ", "+");
		
		/* Set Data Dari Database */
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("isDuplicate", "false");
		parameters.add("legalForm", "1");
		parameters.add("limit", "100");
		parameters.add("locale", "en");
		parameters.add("motherName", "");
		parameters.add("typeOfIdentityId", "IC");
		parameters.add("dateOfBirth", dateOfBirth);
		parameters.add("fullname", fullname);
		parameters.add("identityNumber", paramField.getIdnumber());
		
		HashMap<String, Object> param1 = new HashMap<String, Object>();
		param1.put("url", url);
		param1.put("tenantid", tenantid);
		param1.put("userauth", userauth);
		param1.put("passauth", passauth);
		param1.put("authsimpool", authsimpool);
		param1.put("queryparam", parameters);
		
		HashMap<String, Object> mapreturn = apisimpool.resultGet(param1);
		int code = (Integer) mapreturn.get("code");
		String body = (String) mapreturn.get("body");
		
		JSONObject jsonobj = (JSONObject) JsonHelper.ConvertStringToJson(body);
		List<CustomerEntity> list = new ArrayList<CustomerEntity>();
		if(code == 200) {
			HashMap<String, Object> mapParam = new HashMap<String, Object>();
			mapParam.put("jsonobj", jsonobj);
			list = setJsonToCustomerEntity(mapParam);
		}
		map.put("list", list);
		return map;
	}
	
	public static List<CustomerEntity> searchByTableCust(HashMap<String, Object> param){
		List<CustomerEntity> list = new ArrayList<CustomerEntity>();
		CustomerService custservice = (CustomerService) param.get("custservice");
		CheckUpdateSimpoolJson paramField = (CheckUpdateSimpoolJson) param.get("paramsearch");
		List<CustomerEntity> listcustsimpool = (List<CustomerEntity>) param.get("listcustsimpool");
		if(listcustsimpool.size() > 0) {
			for(CustomerEntity item : listcustsimpool) {
				CustomerEntity serachCFID = custservice.getCustomerByCFOrCustID("", item.getCif_id());
				if(serachCFID != null) {
					list.add(serachCFID);
				}else {
					String fullname = paramField.getFullname().replaceAll(" ", "+").toLowerCase();
					Date dateofbirth = new Date(paramField.getDateofbirth());
					CustomerEntity custentity = custservice.getcustomerbyFieldPriority(fullname, paramField.getIdnumber(), dateofbirth);
					if(custentity != null) {
						item.setCustomerid(custentity.getCustomerid());
						item.setEducation(custentity.getEducation());
						item.setLandlinephone(custentity.getLandlinephone());
						item.setMaritalstatus(custentity.getMaritalstatus());
					}
					custentity = new CustomerEntity();
					custentity = item;
					list.add(custentity);
				}
			}
		}
		if(list.size() == 0) {
			String fullname = paramField.getFullname().replaceAll(" ", "+").toLowerCase();
			Date dateofbirth = new Date(paramField.getDateofbirth());
			CustomerEntity custentity = custservice.getcustomerbyFieldPriority(fullname, paramField.getIdnumber(), dateofbirth);
			if(custentity != null) {
				list.add(custentity);
			}
		}
		
		return list;
	}
	
	private static List<CustomerEntity> setJsonToCustomerEntity(HashMap<String, Object> mapParam) {
		List<CustomerEntity> list = new ArrayList<CustomerEntity>();
		JSONObject jsonobj = (JSONObject) mapParam.get("jsonobj");
		JSONArray jsonarray = (JSONArray) jsonobj.get("pageItems");
		for(int x=0; x < jsonarray.size(); x++) {
			JSONObject item = (JSONObject) jsonarray.get(x);
			Long id = (Long) item.get("id");
			String fullname = (String) item.get("fullname");
			String mobileNo = (String) item.get("mobileNo");
			List<Long> dateOfBirth = (List<Long>) item.get("dateOfBirth");
			String strdateOfBirth = dateOfBirth.get(0)+"-"+dateOfBirth.get(1)+"-"+dateOfBirth.get(2);
			Timestamp tsdateOfBirth = Utils.stringToTimestamp(strdateOfBirth, DateFormatEnum.FORMAT_DATE.value());
			
			String placeOfBirth = (String) item.get("placeOfBirth");
			String identityNumber = (String) item.get("identityNumber");
			String email = (String) item.get("email");
			
			JSONObject itemGender = (JSONObject) item.get("gender");
			String idgender = (String) itemGender.get("name");
			
			CustomerEntity ce = new CustomerEntity();
			ce.setName(fullname);
			ce.setDateofbirth(tsdateOfBirth);
			ce.setMobilephone(mobileNo);
			ce.setGender(idgender);
			ce.setPlaceofbirth(placeOfBirth);
			ce.setIdnumber(identityNumber);
			ce.setTypeid("KTP");
			ce.setEmail(email);
			ce.setCif_id(id.toString());
			ce.setCustomerid("");
			ce.setEducation("");
			ce.setLandlinephone("");
			ce.setMaritalstatus("");
			
			list.add(ce);
		}
		return list;
	}
}
