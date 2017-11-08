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

import czx.system.bean.Menu;

/**  
 * @ClassName	MenuDao.java
 * @Package  	czx.system.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:59:30
 * @version V1.0  
 */
public interface MenuDao {
	
	public List<Menu> queryMenuList();
}


