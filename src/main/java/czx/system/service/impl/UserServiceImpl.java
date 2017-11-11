/**
 * Filename:	UserServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午10:24:26
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.util.ExceptionDealUtil;
import czx.system.bean.User;
import czx.system.dao.UserDao;
import czx.system.service.UserService;

/**  
 * @ClassName	UserServiceImpl.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午10:24:26
 * @version V1.0  
 */
@Scope("prototype")
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public PagingGrid queryUserList(int offset,int limit) {
		int total = userDao.queryUserCount();
		List<User> rows = userDao.queryUserList(offset,limit);
		return new PagingGrid(total, rows);
	}

	@Override
	public Message addUser(User user) {
		Message msg = new Message();
        try {
            if (userDao.isexist(user) != null)
            {
                msg.setSuccess(false);
                msg.setMessage("保存失败:用户ID" + user.getUserId() + "-已存在于数据库中！");
            } else {
            	userDao.addUser(user);
                msg.setSuccess(true);
                msg.setMessage("保存成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setSuccess(false);
            msg.setMessage("保存失败:" + ExceptionDealUtil.getMessage(e));
        }
        return msg;
	}

	@Override
	public Message updateUser(User user) {
		Message msg = new Message();
		try{
			userDao.updateUser(user);
			msg.setSuccess(true);
			msg.setMessage("更新成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("更新失败：" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message deleteUser(List<User> list) {
		Message msg = new Message();
		try{
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("list", list);
			userDao.deleteUser(param);
			msg.setSuccess(true);
			msg.setMessage("删除成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("删除失败："+ ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message resetPwd(String userId, String password) {
		Message msg = new Message();
		try{
			userDao.resetPwd(userId,password);
			msg.setSuccess(true);
			msg.setMessage("密码更改成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("密码更改失败："+ ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

}


