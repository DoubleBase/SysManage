/**
 * Filename:	UserDao.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 上午11:40:59
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.dao;

import java.util.List;
import java.util.Map;

import czx.system.bean.User;

/**  
 * @ClassName	UserDao.java
 * @Package  	czx.sys.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  上午11:40:59
 * @version V1.0  
 */
public interface UserDao {

	public int queryUserCount();
	
	public List<User> queryUserList(int offset,int limit);
	
	public User isexist(User user);
	
	public void addUser(User user);
	
	public void updateUser(User user);

	public void deleteUser(Map<String,Object> list);
}


