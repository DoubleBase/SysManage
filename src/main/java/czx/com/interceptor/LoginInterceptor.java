/**
 * Filename:	LoginInterceptor.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:04:51
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.com.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import czx.com.controller.BaseController;
import czx.system.bean.User;
import czx.system.service.LoginService;

/**  
 * @ClassName	LoginInterceptor.java
 * @Package  	czx.com.interceptor
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:04:51
 * @version V1.0  
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception
    {

        // 获取请求的URL
        String url = request.getRequestURI();
        // URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if (url.indexOf("system_Login") >= 0 || url.indexOf("install_Install") >= 0)
        {
            return true;
        }


        /*if (request.getParameter("userid") != null )
        {
            // 模拟登录
            String userid = request.getParameter("userid");
            String loginname = request.getParameter("loginname");
            String username = request.getParameter("username");
            String verifycode = request.getParameter("verifycode");
            String mobilephone = request.getParameter("mobilephone");
            if (request.getSession().getAttribute(BaseController.SESSION_ATTRIBUTE_USER) == null)
            {
                loginService.loginByPortal(userid, loginname, username, verifycode, mobilephone, request);
            }
        }
        
        if(request.getParameter("priv_id")!=null){
            request.setAttribute("menuId", request.getParameter("priv_id"));
        }*/

        // 获取Session
        HttpSession session = request.getSession();
        User userInfo = (User) session.getAttribute(BaseController.SESSION_USER);

        if (userInfo == null)
        {
            request.getRequestDispatcher("system_Login!view.do").forward(request, response);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception
    {
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception
    {
        super.afterCompletion(arg0, arg1, arg2, arg3);
    }
	
}


