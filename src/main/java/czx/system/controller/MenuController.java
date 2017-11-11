/**
 * Filename:	MenuController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午4:29:49
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.controller;

import java.util.HashMap;
import java.util.List;
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
import czx.system.bean.Fun;
import czx.system.bean.MenuItem;
import czx.system.service.MenuService;

/**  
 * @ClassName	MenuController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午4:29:49
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class MenuController extends BaseController{
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("/system_Menu!view.do")
	public ModelAndView view(String menuId){
		Map<String,String> map = new HashMap<String,String>();
		map.put("menuId", menuId);
		return new ModelAndView("/system/menu",map);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!getMenuTree.do")
	public List<MenuItem> getMenuTree(String id){
		return menuService.getMenuTree(id);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!addMenu.do")
	public Message addMenu(MenuItem menu){
		return menuService.addMenu(menu);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!updateMenu.do")
	public Message updateMenu(MenuItem menu){
		return menuService.updateMenu(menu);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!deleteMenu.do")
	public Message deleteMenu(String id){
		return menuService.deleteMenu(id);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!getMenuRoleByMenuId.do")
	public PagingGrid getMenuRoleByMenuId(String menuId){
		return menuService.getMenuRoleByMenuId(menuId);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!saveMenuRole.do")
	public Message saveMenuRole(String menuId,String roleIds){
		return menuService.saveMenuRole(menuId, roleIds);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!queryFunByMenuId.do")
	public PagingGrid queryFunByMenuId(int menuId,int offset,int limit){
		return menuService.queryFunByMenuId(menuId, offset, limit);
	}

	@ResponseBody
	@RequestMapping("/system_Menu!addMenuFun.do")
	public Message addMenuFun(Fun fun){
		return menuService.addMenuFun(fun);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!updateMenuFun.do")
	public Message updateMenuFun(Fun fun){
		return menuService.updateMenuFun(fun);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!deleteMenuFun.do")
	public Message deleteMenuFun(String funIds){
		return menuService.deleteMenuFun(funIds);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!getFunRoleByfunId.do")
	public PagingGrid getFunRoleByfunId(int funId,int offset,int limit){
		return menuService.getFunRoleByfunId(funId, offset, limit);
	}
	
	@ResponseBody
	@RequestMapping("/system_Menu!saveFunRole.do")
	public Message saveFunRole(int funId,String roleIds){
		return menuService.saveFunRole(funId, roleIds);
	}
}


