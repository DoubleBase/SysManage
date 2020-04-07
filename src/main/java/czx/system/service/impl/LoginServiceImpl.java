/**
 * Filename:	LoginServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:23:05
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.com.bean.Message;
import czx.com.controller.BaseController;
import czx.com.util.ExceptionDealUtil;
import czx.system.bean.User;
import czx.system.dao.LoginDao;
import czx.system.service.LoginService;

/**  
 * @ClassName	LoginServiceImpl.java
 * @Package  	czx.sys.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:23:05
 * @version V1.0  
 */
@Service
public class LoginServiceImpl implements LoginService {

	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Resource
	private LoginDao loginDao;
	
	@Override
	public Message login(User user, HttpSession session) {
		Message msg = new Message();
		try{
			User loginUser = loginDao.login(user);
			if(loginUser!=null){
				session.setAttribute(BaseController.SESSION_USER, loginUser);
				msg.setSuccess(true);
				msg.setMessage("登录成功!");
			}else{
				msg.setSuccess(false);
				msg.setMessage("登录失败:用户名或密码错误!");
			}
		}catch(Exception e){
			log.error(e.getMessage(),e);
			msg.setSuccess(false);
			msg.setMessage("登录失败:" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

}


