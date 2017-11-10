/**
 * Filename:	RoleDao.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 上午10:01:43
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.dao;

import java.util.List;
import java.util.Map;

import czx.system.bean.MenuTree;
import czx.system.bean.Role;

/**  
 * @ClassName	RoleDao.java
 * @Package  	czx.system.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  上午10:01:43
 * @version V1.0  
 */
public interface RoleDao {
	public int queryRoleCount();
	
	public List<Role> queryRoleList(int offset,int limit);
	
	public Role isexist(Role role);
	
	public void addRole(Role role);
	
	public void updateRole(Role role);

	public void deleteRole(Map<String,Object> list);
	
	public List<MenuTree> getRoleMenuByRoleId(String roldId);
	
	public void addRoleMenu(Map<String,Object> list);
	
	public void deleteRoleMenu(int roleId);
	
}


