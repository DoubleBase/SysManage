/**
 * Filename:	UserRoleService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 下午1:00:46
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.service;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;

/**  
 * @ClassName	UserRoleService.java
 * @Package  	czx.system.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  下午1:00:46
 * @version V1.0  
 */
public interface UserRoleService {

	public PagingGrid getUserRoleByUserId(String userId);
	
	public Message saveUserRole(String userId,String roleIds);
}


