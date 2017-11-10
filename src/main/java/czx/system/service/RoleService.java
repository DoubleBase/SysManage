/**
 * Filename:	RoleService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 上午10:02:45
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.service;

import java.util.List;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.system.bean.MenuTree;
import czx.system.bean.Role;

/**  
 * @ClassName	RoleService.java
 * @Package  	czx.system.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  上午10:02:45
 * @version V1.0  
 */
public interface RoleService {
	public PagingGrid queryRoleList(int offset,int limit);
	
	public Message addRole(Role role);
	
	public Message updateRole(Role role);
	
	public Message deleteRole(List<Role> list);
	
	public List<MenuTree> getRoleMenuByRoleId(String roleId);
	
	public Message saveRoleMenu(int roleId,String menuIds);
	
}


