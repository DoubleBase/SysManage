/**
 * Filename:	LoginService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午1:22:41
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.service;

import javax.servlet.http.HttpSession;

import czx.com.bean.Message;
import czx.system.bean.User;

/**  
 * @ClassName	LoginService.java
 * @Package  	czx.sys.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午1:22:41
 * @version V1.0  
 */
public interface LoginService {

	public Message login(User user,HttpSession session);
}


