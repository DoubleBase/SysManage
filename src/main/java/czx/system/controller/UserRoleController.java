/**
 * Filename:	UserRoleController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 上午11:49:30
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.controller.BaseController;
import czx.system.service.UserRoleService;

/**  
 * @ClassName	UserRoleController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  上午11:49:30
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class UserRoleController extends BaseController {

	@Resource
	private UserRoleService userRoleService;
	
	@RequestMapping("/system_UserRole!view.do")
	public ModelAndView view(String userId){
		Map<String, String> map = new HashMap<String,String>();
		map.put("userId", userId);
		return new ModelAndView("/system/userrole",map);
	}
	
	@ResponseBody
	@RequestMapping("/system_UserRole!getUserRoleByUserId.do")
	public PagingGrid getUserRoleByUserId(String userId){
		return userRoleService.getUserRoleByUserId(userId);
	}
	
	@ResponseBody
	@RequestMapping("/system_UserRole!saveUserRole.do")
	public Message saveUserRole(String userId,String roleIds){
		return userRoleService.saveUserRole(userId, roleIds);
	}
}


