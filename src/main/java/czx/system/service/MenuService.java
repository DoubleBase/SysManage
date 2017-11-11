/**
 * Filename:	MenuService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午3:58:36
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.service;

import java.util.List;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.system.bean.Fun;
import czx.system.bean.Menu;
import czx.system.bean.MenuItem;
import czx.system.bean.User;

/**  
 * @ClassName	MenuService.java
 * @Package  	czx.system.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:58:36
 * @version V1.0  
 */
public interface MenuService {

	public List<Menu> queryMenuList(User user);
	
	public List<MenuItem> getMenuTree(String id);
	
	public Message addMenu(MenuItem menu);
	
	public Message updateMenu(MenuItem menu);
	
	public Message deleteMenu(String id);
	
	public PagingGrid getMenuRoleByMenuId(String menuId);
	
	public Message saveMenuRole(String menuId,String roleIds);
	
	public PagingGrid queryFunByMenuId(int menuId,int offset,int limit);
	
	public Message addMenuFun(Fun fun);
	
	public Message updateMenuFun(Fun fun);
	
	public Message deleteMenuFun(String funIds);
	
	public PagingGrid getFunRoleByfunId(int funId,int offset,int limit);
	
	public Message saveFunRole(int funId,String roleIds);
}


