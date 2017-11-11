/**
 * Filename:	SysToolbarDao.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月11日 下午4:16:54
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月11日	 czx			1.0				1.0 version
 */
package czx.system.dao;

import java.util.List;

import czx.system.bean.Fun;

/**  
 * @ClassName	SysToolbarDao.java
 * @Package  	czx.system.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月11日  下午4:16:54
 * @version V1.0  
 */
public interface SysToolbarDao {
	
	public List<Fun> getRoleFunctionList(int menuId,String userId);
}


