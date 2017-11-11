/**
 * Filename:	MenuDao.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午3:59:30
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.dao;

import java.util.List;
import java.util.Map;

import czx.system.bean.Fun;
import czx.system.bean.Menu;
import czx.system.bean.MenuItem;
import czx.system.bean.Role;
import czx.system.bean.User;

/**  
 * @ClassName	MenuDao.java
 * @Package  	czx.system.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:59:30
 * @version V1.0  
 */
public interface MenuDao {
	
	public List<Menu> queryMenuList(User user);
	
	public List<MenuItem> queryMenuTreeChildren(String id);
	
	public MenuItem isexist(MenuItem menu);
	
	public void addMenu(MenuItem menu);
	
	public void updateMenu(MenuItem menu);
	
	public void deleteMenu(String id);
	
	public List<Role> getMenuRoleByMenuId(String menuId);
	
	public void deleteMenuRole(String menuId);
	
	public void addMenuRole(Map<String,Object> param);
	
	public List<Fun> queryFunByMenuId(int menuId,int offset,int limit);
	
	public Fun isexistFun(Fun fun);
	
	public void addMenuFun(Fun fun);
	
	public void updateMenuFun(Fun fun);
	
	public void deleteMenuFun(Map<String,Object> param);
	
	public List<Role> getFunRoleByfunId(int funId,int offset,int limit);
	
	public void deleteFunRole(int funId);
	
	public void addFunRole(Map<String,Object> param);
}


