/**
 * Filename:	FrameController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 上午10:45:03
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
import javax.json.JsonArray;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import czx.com.controller.BaseController;
import czx.system.bean.Menu;
import czx.system.service.MenuService;

/**  
 * @ClassName	FrameController.java
 * @Package  	czx.sys.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  上午10:45:03
 * @version V1.0  
 */
@Controller
public class FrameController extends BaseController{
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("/system_Frame!view.do")
	public ModelAndView view(String menuName){
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", getSessionUser().getUserName());
		map.put("userId", getSessionUser().getUserId());
		
		List<Menu> menu = menuService.queryMenuList();
		map.put("menus",JSONArray.fromObject(menu).toString());
		
		return new ModelAndView("/system/frame",map);
	}

}


