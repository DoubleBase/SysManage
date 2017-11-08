/**
 * Filename:	TestController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月7日 下午11:03:16
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月7日	 czx			1.0				1.0 version
 */
package czx.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**  
 * @ClassName	TestController.java
 * @Package  	czx.test.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月7日  下午11:03:16
 * @version V1.0  
 */
@Controller
public class TestController extends AbstractController{

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String test(ModelMap model){
		System.out.println("======");
		model.addAttribute("name", "SZF");
		
		return "hello";
		//return "redirect:hello" 页面重定向
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}


