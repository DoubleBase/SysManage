/**
 * Filename:	BaseController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:05:45
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.com.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import czx.system.bean.User;

/**  
 * @ClassName	BaseController.java
 * @Package  	czx.com.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:05:45
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class BaseController {
	
	public static final String SESSION_USER = "user";
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected ServletContext servletContext;
	
	protected HttpSession session;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.servletContext = request.getSession().getServletContext();
		this.session = request.getSession();
	}
	
	public User getSessionUser(){
		return (User)session.getAttribute(SESSION_USER);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	
}


