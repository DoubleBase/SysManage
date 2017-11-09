/**
 * Filename:	UserRoleServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 下午1:00:36
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.util.ExceptionDealUtil;
import czx.com.util.StringUtils;
import czx.system.bean.Role;
import czx.system.dao.UserRoleDao;
import czx.system.service.UserRoleService;

/**  
 * @ClassName	UserRoleServiceImpl.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  下午1:00:36
 * @version V1.0  
 */
@Scope("prototype")
@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Resource
	private UserRoleDao userRoleDao;
	
	@Override
	public PagingGrid getUserRoleByUserId(String userId) {
		List<Role> rows = userRoleDao.getUserRoleByUserId(userId);
		return new PagingGrid(rows.size(), rows);
	}

	@Override
	public Message saveUserRole(String userId, String roleIds) {
		Message msg = new Message();
		try{
			List<String> roleIdList = StringUtils.strToListBySplit(roleIds, ",");
			userRoleDao.deleteUserRole(userId);
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("userId", userId);
			params.put("list", roleIdList);
			if(roleIdList.get(0)!=""){
				userRoleDao.saveUserRole(params);
			}
			msg.setSuccess(true);
			msg.setMessage("角色绑定成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("角色绑定失败：" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}
	
}


