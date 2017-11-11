/**
 * Filename:	UserController.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午10:19:14
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

import net.sf.json.JSONArray;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.controller.BaseController;
import czx.system.bean.User;
import czx.system.service.UserService;

/**  
 * @ClassName	UserController.java
 * @Package  	czx.system.controller
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午10:19:14
 * @version V1.0  
 */
@Scope("prototype")
@Controller
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/system_User!view.do")
	public ModelAndView view(String menuId){
		Map<String,String> map = new HashMap<String,String>();
		map.put("menuId", menuId);
		return new ModelAndView("/system/user",map);
	}
	
	@ResponseBody
	@RequestMapping("/system_User!queryUserList.do")
	public PagingGrid queryUserList(int offset,int limit){
		return userService.queryUserList(offset,limit);
	}
	
	@ResponseBody
	@RequestMapping("/system_User!addUser.do")
	public Message addUser(User user){
		return userService.addUser(user);
	}
	
	@ResponseBody
	@RequestMapping("/system_User!updateUser.do")
	public Message updateUser(User user){
		return userService.updateUser(user);
	}
	
	@ResponseBody
	@RequestMapping("/system_User!deleteUser.do")
	public Message deleteUser(User user){
		List<User> list = JSONArray.toList(JSONArray.fromObject(request.getParameter("dataList")), User.class);
		return userService.deleteUser(list);
	}
	
	@ResponseBody
	@RequestMapping("/system_User!resetPwd.do")
	public Message resetPwd(String userId,String password){
		return userService.resetPwd(userId, password);
	}
	
}


