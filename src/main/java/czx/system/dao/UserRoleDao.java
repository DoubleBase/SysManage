/**
 * Filename:	UserRoleDao.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 下午1:02:54
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.dao;

import java.util.List;
import java.util.Map;

import czx.system.bean.Role;

/**  
 * @ClassName	UserRoleDao.java
 * @Package  	czx.system.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  下午1:02:54
 * @version V1.0  
 */
public interface UserRoleDao {

	public List<Role> getUserRoleByUserId(String userId);
	
	public void deleteUserRole(String userId);
	
	public void saveUserRole(Map<String,Object> param);
}


