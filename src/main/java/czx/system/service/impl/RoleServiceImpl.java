/**
 * Filename:	RoleServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 上午10:03:08
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.com.bean.Message;
import czx.com.bean.PagingGrid;
import czx.com.util.ExceptionDealUtil;
import czx.com.util.StringUtils;
import czx.system.bean.MenuItem;
import czx.system.bean.MenuTree;
import czx.system.bean.Role;
import czx.system.dao.RoleDao;
import czx.system.service.RoleService;

/**  
 * @ClassName	RoleServiceImpl.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  上午10:03:08
 * @version V1.0  
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Override
	public PagingGrid queryRoleList(int offset, int limit) {
		int total = roleDao.queryRoleCount();
		List<Role> rows = roleDao.queryRoleList(offset, limit);
		return new PagingGrid(total, rows);
	}

	@Override
	public Message addRole(Role role) {
		Message msg = new Message();
		try{
			if (roleDao.isexist(role) != null){
                msg.setSuccess(false);
                msg.setMessage("保存失败:角色ID" + role.getRoleId() + "-已存在于数据库中！");
            }else{
            	roleDao.addRole(role);
    			msg.setSuccess(true);
    			msg.setMessage("添加成功");
            }
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("添加失败：" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message updateRole(Role role) {
		Message msg = new Message();
		try{
			roleDao.updateRole(role);
			msg.setSuccess(true);
			msg.setMessage("修改成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("修改失败：" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message deleteRole(List<Role> list) {
		Message msg = new Message();
		try{
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("list",list);
			roleDao.deleteRole(param);
			msg.setSuccess(true);
			msg.setMessage("删除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("删除失败：" + ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public List<MenuTree> getRoleMenuByRoleId(String roldId) {
		List<MenuTree> list = new ArrayList<MenuTree>();
		list = roleDao.getRoleMenuByRoleId(roldId);
		list = MenuTree.toTreeNode(list,"0") ;
		return list;
	}

	@Override
	public Message saveRoleMenu(int roleId, String menuIds) {
		Message msg = new Message();
		try{
			Map<String,Object> param = new HashMap<String,Object>();
			List<String> list = StringUtils.strToListBySplit(menuIds, ",");
			param.put("roleId", roleId);
			param.put("list", list);
			roleDao.deleteRoleMenu(roleId);
			if(list.size()>0 && !"".equals(list.get(0))){
				roleDao.addRoleMenu(param);
			}
			msg.setSuccess(true);
			msg.setMessage("保存成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("保存失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

}


