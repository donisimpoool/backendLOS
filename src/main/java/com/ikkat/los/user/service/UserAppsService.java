package com.ikkat.los.user.service;


import com.ikkat.los.shared.ReturnData;
import com.ikkat.los.user.entity.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface UserAppsService {
	List<UserApps> getListLogin(HashMap<String, Object> hashparam);
	Collection<UserPermissionData> getListUserPermission(long id);
	ReturnLoginApps actionLogin(String username, String password);
	List<UserApps> getUserLoginByUserName(String username);
	ReturnData saveUserApps(BodyUserApps userapps, long idcompany, long idbranch);
	ReturnData editUserApps(long id,BodyUserApps userapps);
	UserDetailData getDetailUserApps(long id, String idcompany, long idbranch);
	List<UserListData> getListAllUser(long idcompany,long idbranch);
	ReturnData deleteUserApss(long id);
	TemplateInternalUser getTemplate(long idcompany,long idbranch);

}
