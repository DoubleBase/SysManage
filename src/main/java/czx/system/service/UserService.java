/**
 * Filename:	UserService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午10:23:51
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
import czx.system.bean.User;

/**  
 * @ClassName	UserService.java
 * @Package  	czx.system.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午10:23:51
 * @version V1.0  
 */
public interface UserService {
	public PagingGrid queryUserList(int offset,int limit);
	
	public Message addUser(User user);
	
	public Message updateUser(User user);
	
	public Message deleteUser(List<User> list);
}


