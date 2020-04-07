/**
 * Filename:	LoginController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:44:03
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
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
import czx.com.controller.BaseController;
import czx.system.bean.User;
import czx.system.service.LoginService;

/**  
 * @ClassName	LoginController.java
 * @Package  	czx.sys.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:44:03
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class LoginController extends BaseController{
	
	@Resource
	private LoginService service;
	
	@RequestMapping("/system_Login!view.do")
	public ModelAndView view(){
		Map<String,String> map = new HashMap<String,String>();
		return new ModelAndView("/system/login",map);
	}
	
	@ResponseBody
	@RequestMapping("/system_Login!login.do")
	public Message login(User user){
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("password"));
		return service.login(user, session);
	}
	
}


