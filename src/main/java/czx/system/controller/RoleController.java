/**
 * Filename:	RoleController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 上午10:01:24
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.controller.BaseController;
import czx.system.bean.Role;
import czx.system.service.RoleService;

/**  
 * @ClassName	RoleController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  上午10:01:24
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class RoleController extends BaseController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("/system_Role!view.do")
	public ModelAndView view(){
		return new ModelAndView("/system/role");
	}
	
	@ResponseBody
	@RequestMapping("/system_Role!queryRoleList.do")
	public PagingGrid queryRoleList(int offset,int limit){
		return roleService.queryRoleList(offset,limit);
	}
	
	@ResponseBody
	@RequestMapping("/system_Role!addRole.do")
	public Message addRole(Role Role){
		return roleService.addRole(Role);
	}
	
	@ResponseBody
	@RequestMapping("/system_Role!updateRole.do")
	public Message updateRole(Role Role){
		return roleService.updateRole(Role);
	}
	
	@ResponseBody
	@RequestMapping("/system_Role!deleteRole.do")
	public Message deleteRole(Role Role){
		List<Role> list = JSONArray.toList(JSONArray.fromObject(request.getParameter("dataList")), Role.class);
		return roleService.deleteRole(list);
	}
}


