/**
 * Filename:	SysToolbarService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月11日 下午4:15:16
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月11日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.system.bean.Fun;
import czx.system.dao.SysToolbarDao;
import czx.system.service.SysToolbarService;

/**  
 * @ClassName	SysToolbarService.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月11日  下午4:15:16
 * @version V1.0  
 */
@Service
public class SysToolbarServiceImpl implements SysToolbarService{

	@Resource
	private SysToolbarDao systoolbarDao;
	@Override
	public List<Fun> getRoleFunctionList(int menuId,String userId) {
		return systoolbarDao.getRoleFunctionList(menuId,userId);
	}

}


