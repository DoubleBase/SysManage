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
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import czx.com.controller.BaseController;

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
	
	@RequestMapping("/system_Menu!view.do")
	public ModelAndView view(){
		Map<String,String> map = new HashMap<String,String>();
		return new ModelAndView("/system/menu",map);
	}
	
	
}


