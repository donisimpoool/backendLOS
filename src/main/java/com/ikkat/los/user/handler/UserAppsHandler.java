package com.ikkat.los.user.handler;


import com.ikkat.los.admin.role.service.RoleService;
import com.ikkat.los.admin.userappsrole.entity.UserAppsRoleData;
import com.ikkat.los.admin.userappsrole.service.UserAppsRoleService;
import com.ikkat.los.security.entity.AuthorizationData;
import com.ikkat.los.security.entity.SecurityLicenseData;
import com.ikkat.los.security.service.SecurityService;
import com.ikkat.los.shared.*;
import com.ikkat.los.user.entity.*;
import com.ikkat.los.user.mapper.GetListAllUser;
import com.ikkat.los.user.mapper.UserPermissionMapper;
import com.ikkat.los.user.repo.UserAppsRepo;
import com.ikkat.los.user.service.UserAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;


@Service
public class UserAppsHandler implements UserAppsService {
	@Autowired
	private UserAppsRepo repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	SecurityService securityService;
	@Autowired
	UserAppsRoleService userAppsRoleService;
	@Autowired
	RoleService roleService;

	@Override
	public List<UserApps> getListLogin(HashMap<String, Object> hashparam) {
		// TODO Auto-generated method stub
		ParamUser param = new ParamUser(hashparam);
		return repository.getUserLogin(param);
	}

	@Override
	public Collection<UserPermissionData> getListUserPermission(long id) {
		// TODO Auto-generated method stub
		final StringBuilder sqlBuilder = new StringBuilder("select " + new UserPermissionMapper().schema());
		sqlBuilder.append(" where mur.iduserapps = ?  ");
		final Object[] queryParameters = new Object[] { id };
		return this.jdbcTemplate.query(sqlBuilder.toString(), new UserPermissionMapper(), queryParameters);
	}

	@Override
	public ReturnLoginApps actionLogin(String username, String password) {
		// TODO Auto-generated method stub
		List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
		AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
		UserData userdata = null;
		ReturnData returndata = null;
		List<UserApps> list = repository.getUserLoginByUsername(username);
		String tempusername = "";
		long idcompany = 0;
		long idbranch = 0;
		for(UserApps user : list) {
			String passwordDB = aesEncryptionDecryption.decrypt(user.getPassword());
			if(passwordDB.equals(password)) {
				tempusername = username;
				idcompany = user.getCompanyid();
				idbranch = user.getBranchid();
				SecurityLicenseData license = securityService.checkLicense(user.getCompanyid(), null, null);
				returndata = new ReturnData();
				returndata = license.getReturnData();
				if(returndata.isSuccess()) {
					AuthorizationData dataauth = new AuthorizationData();
					String passwordtoken = securityService.passwordToken(username, password);
					String encryptedPassToken = aesEncryptionDecryption.encrypt(passwordtoken);
					Timestamp ts = new Timestamp(new Date().getTime());
					dataauth.setId(user.getId());
					dataauth.setUsername(username);
					dataauth.setPassword(password);
					dataauth.setDatelogin(ts);
					dataauth.setPasswordtoken(encryptedPassToken);
					dataauth.setIdcompany(user.getCompanyid());
					dataauth.setIdbranch(user.getBranchid());
					dataauth.setTypelogin(ConstansKey.TYPE_WEB);
					
					String encryptedString = aesEncryptionDecryption.encrypt(new ConvertJson().toJsonString(dataauth));
					
					userdata = new UserData();
					userdata.setPermissions(setPermissions(user.getId()));
					userdata.setToken(encryptedString);


//					UserApps userapps = repository.getOne(user.getId());
//					userapps.setToken(encryptedString);
//					repository.saveAndFlush(userapps);
				}
				break;
			}
		}
		ReturnLoginApps data = new ReturnLoginApps();
		data.setReturnData(returndata);
		data.setUserData(userdata);
		data.setUsername(tempusername);
		data.setIdcompany(idcompany);
		data.setIdbranch(idbranch);
		return data;
	}
	
	private List<String> setPermissions(long id){
		List<String> list = new ArrayList<String>();
		List<UserPermissionData> listp = new ArrayList<UserPermissionData>(getListUserPermission(id));
		for(UserPermissionData permission : listp) {
			list.add(permission.getPermissioncode());
		}
		return list;
	}

	@Override
	public List<UserApps> getUserLoginByUserName(String username) {
		// TODO Auto-generated method stub
		return repository.getUserLoginByUsername(username);
	}

	@Override
	public ReturnData saveUserApps(BodyUserApps userapps,long idcompany,long idbranch) {
		// TODO Auto-generated method stub
		List<ValidationDataMessage> validations = new ArrayList<ValidationDataMessage>();
		AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
		String passwordDB = aesEncryptionDecryption.encrypt(userapps.getPassword());
		Timestamp ts = new Timestamp(new Date().getTime());
		UserApps table = new UserApps();
		table.setUserid(userapps.getUsername());
		table.setPassword(passwordDB);
		table.setName(userapps.getNama());
		table.setLevel(userapps.getLevel());
		table.setIsapproval(userapps.getIsapproval());
		table.setUsertype(userapps.getUsertype());
		table.setLimitsizefile(userapps.getLimitsizefile());
		table.setIsactive(true);
//		List<UserListData> listAllUserByIdCompany = getListAllUserByIdCompany(idcompany);
		List<UserApps> checkUsername = repository.getUserLoginByUsername(userapps.getUsername());
		long idreturn = 0;
		
//		SecurityLicenseData checkLicense = securityService.checkLicense(idcompany, new Integer(listAllUserByIdCompany.size() + 1).longValue(),null);
//		if(!checkLicense.getReturnData().isSuccess()) {
//			List<ValidationDataMessage> listvalidLicense = checkLicense.getReturnData().getValidations();
//			if(listvalidLicense.size() > 0) {
//				for(ValidationDataMessage licenseMsg : listvalidLicense) {
//					if(!licenseMsg.getMessageCode().equals(ConstansCodeMessage.COMPANY_LICENSE_ALERT_EXPIRED)) {
//						ValidationDataMessage msg = new ValidationDataMessage(licenseMsg.getMessageCode(),licenseMsg.getMessage());
//						validations.add(msg);
//					}
//				}
//			}
//		}else
		if(checkUsername != null && checkUsername.size() > 0) {
			ValidationDataMessage msg = new ValidationDataMessage(ConstansCodeMessage.USERNAME_IS_EXIST,"Username Sudah Terpakai");
			validations.add(msg);
		}else {
			UserApps user = repository.saveAndFlush(table);
			idreturn = user.getId();
			
//			List<UserAppsRole> listsave = new ArrayList<UserAppsRole>();
//			if(userapps.getRoles().length > 0) {
//				for (int i = 0; i < userapps.getRoles().length; i++) {
//					UserAppsRolePK pk = new UserAppsRolePK();
//					pk.setIdrole(userapps.getRoles()[i]);
//					pk.setIduserapps(user.getId());
//					UserAppsRole userAppsRole = new UserAppsRole();
//					userAppsRole.setUserAppsRolePK(pk);
//					listsave.add(userAppsRole);
//				}
//				userAppsRoleService.saveUserAppsRoleList(listsave);
//			}
		}
		
		ReturnData data = new ReturnData();
		data.setId(idreturn);
		data.setSuccess(validations.size() > 0?false:true);
		data.setValidations(validations);
		return data;
	}

	@Override
	public UserDetailData getDetailUserApps(long id,String idcompany,long idbranch) {
		// TODO Auto-generated method stub
		List<UserApps> list = repository.getUserById(id, idcompany, idbranch);
		if(list != null && list.size() > 0) {
			List<UserAppsRoleData> listroleuser = new ArrayList<UserAppsRoleData>(userAppsRoleService.getListUserAppsRole(id));
			UserApps data = list.get(0);
//			data.setToken("");
//			data.setIdcompany(0);
//			data.setIdbranch(0);
			if(data.getUserid().equalsIgnoreCase("superuser")) {
				return null;
			}
			UserDataDetail datadetail = new UserDataDetail();
			datadetail.setId(data.getId());
			datadetail.setUserid(data.getUserid());
			datadetail.setPassword(data.getPassword());
			datadetail.setName(data.getName());
			datadetail.setLevel(data.getLevel());
			datadetail.setIsapproval(data.getIsapproval());
			datadetail.setIsactive(data.isIsactive());
			datadetail.setUsertype(data.getUsertype());
			datadetail.setIsactive(data.isIsactive());

			UserDetailData userdetail = new UserDetailData();
			userdetail.setUser(datadetail);
			userdetail.setRoles(listroleuser);
			return userdetail;
		}
		return null;
	}

	@Override
	public ReturnData editUserApps(long id,BodyUserApps userapps) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(new Date().getTime());
//		UserApps table = repository.getById(id);
//		table.setUsername(userapps.getUsername());
//		table.setNama(userapps.getNama());
//		table.setNotelepon(userapps.getNotelepon());
//		table.setIsactive(userapps.getIsactive());
//		table.setEmail(userapps.getEmail());
//		table.setAddress(userapps.getAddress());
//		table.setModified(ts);
		
//		UserApps user = repository.saveAndFlush(table);
		
//		List<UserAppsRolePK> listdelete = new ArrayList<UserAppsRolePK>();
//		List<UserAppsRoleData> listroleuser = new ArrayList<UserAppsRoleData>(userAppsRoleService.getListUserAppsRole(id));
//		if(listroleuser.size() > 0) {
//			for(UserAppsRoleData data : listroleuser) {
//				UserAppsRolePK pk = new UserAppsRolePK();
//				pk.setIdrole(data.getId());
//				pk.setIduserapps(id);
//				listdelete.add(pk);
//			}
//			userAppsRoleService.deleteAllUserAppsRolePKPK(listdelete);
//		}
		
//		List<UserAppsRole> listsave = new ArrayList<UserAppsRole>();
//		if(userapps.getRoles().length > 0) {
//			for (int i = 0; i < userapps.getRoles().length; i++) {
//				UserAppsRolePK pk = new UserAppsRolePK();
//				pk.setIdrole(userapps.getRoles()[i]);
//				pk.setIduserapps(user.getId());
//				UserAppsRole userAppsRole = new UserAppsRole();
//				userAppsRole.setUserAppsRolePK(pk);
//				listsave.add(userAppsRole);
//			}
//			userAppsRoleService.saveUserAppsRoleList(listsave);
//		}
		
		ReturnData data = new ReturnData();
//		data.setId(user.getId());
		
		return data;
	}

	@Override
	public List<UserListData> getListAllUser(long idcompany, long idbranch) {
		// TODO Auto-generated method stub
		final StringBuilder sqlBuilder = new StringBuilder("select " + new GetListAllUser().schema());
		sqlBuilder.append(" where mua.idcompany = ? and mua.idbranch = ? and mua.isdelete = false and mua.username != 'superuser' ");
		final Object[] queryParameters = new Object[] { idcompany , idbranch};
		return this.jdbcTemplate.query(sqlBuilder.toString(), new GetListAllUser(), queryParameters);
	}
	
	private List<UserListData> getListAllUserByIdCompany(long idcompany) {
		// TODO Auto-generated method stub
		final StringBuilder sqlBuilder = new StringBuilder("select " + new GetListAllUser().schema());
		sqlBuilder.append(" where mua.idcompany = ? and mua.isdelete = false ");
		final Object[] queryParameters = new Object[] { idcompany};
		return this.jdbcTemplate.query(sqlBuilder.toString(), new GetListAllUser(), queryParameters);
	}

	@Override
	public ReturnData deleteUserApss(long id) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(new Date().getTime());
//		UserApps table = repository.getOne(id);
//		table.setIsdelete(true);
//		table.setModified(ts);
//		UserApps returntable = repository.saveAndFlush(table);
		
		ReturnData data = new ReturnData();
//		data.setId(returntable.getId());
		return data;
	}

	@Override
	public TemplateInternalUser getTemplate(long idcompany, long idbranch) {
		// TODO Auto-generated method stub
		TemplateInternalUser data = new TemplateInternalUser();
		data.setRoleoptions(roleService.getAllListRole(idcompany, idbranch));
		return data;
	}

}
