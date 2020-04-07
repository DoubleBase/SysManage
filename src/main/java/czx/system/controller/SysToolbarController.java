/**
 * Filename:	SysToolbarController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月11日 下午4:17:44
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月11日	 czx			1.0				1.0 version
 */
package czx.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import czx.com.controller.BaseController;
import czx.system.bean.Fun;
import czx.system.service.SysToolbarService;

/**  
 * @ClassName	SysToolbarController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月11日  下午4:17:44
 * @version V1.0  
 */
@Controller
public class SysToolbarController extends BaseController{

	@Resource
	private SysToolbarService systoolbarService;
	
	@ResponseBody
	@RequestMapping("/system_SysToolbar!getRoleFunctionList.do")
	public List<Fun> getRoleFunctionList(int menuId){
		return systoolbarService.getRoleFunctionList(menuId,getSessionUser().getUserId());
	}
}


