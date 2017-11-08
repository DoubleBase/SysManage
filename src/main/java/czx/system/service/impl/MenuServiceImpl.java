/**
 * Filename:	MenuServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午3:59:16
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.system.bean.Menu;
import czx.system.dao.MenuDao;
import czx.system.service.MenuService;

/**  
 * @ClassName	MenuServiceImpl.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:59:16
 * @version V1.0  
 */
@Scope("prototype")
@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<Menu> queryMenuList() {
		return Menu.toTreeNode(menuDao.queryMenuList(), 0);
	}

}


