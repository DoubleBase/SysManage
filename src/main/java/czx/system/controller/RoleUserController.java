/**
 * Filename:	RoleUserController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 下午2:21:25
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
import czx.system.service.RoleUserService;

/**  
 * @ClassName	RoleUserController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  下午2:21:25
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class RoleUserController extends BaseController {

	@Resource
	private RoleUserService roleUserService;
	
	@RequestMapping("/system_RoleUser!view.do")
	public ModelAndView view(String roleId){
		Map<String,String> map = new HashMap<String,String>();
		map.put("roleId", roleId);
		return new ModelAndView("/system/roleuser",map);
	}
	
	@ResponseBody
	@RequestMapping("/system_RoleUser!getRoleUserByRoleId.do")
	public PagingGrid getRoleUserByRoleId(String roleId){
		return roleUserService.getRoleUserByRoleId(roleId);
	}
	
	@ResponseBody
	@RequestMapping("/system_RoleUser!saveRoleUser.do")
	public Message saveRoleUser(String roleId,String userIds){
		return roleUserService.saveRoleUser(roleId, userIds);
	}
}


