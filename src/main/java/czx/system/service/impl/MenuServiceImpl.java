/**
 * Filename:	MenuServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午3:59:16
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
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
import czx.system.bean.Fun;
import czx.system.bean.Menu;
import czx.system.bean.MenuItem;
import czx.system.bean.Role;
import czx.system.bean.User;
import czx.system.dao.MenuDao;
import czx.system.service.MenuService;

/**  
 * @ClassName	MenuServiceImpl.java
 * @Package  	czx.system.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:59:16
 * @version V1.0  
 */
@Scope("prototype")
@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<Menu> queryMenuList(User user) {
		return Menu.toTreeNode(menuDao.queryMenuList(user), 0);
	}

	@Override
	public List<MenuItem> getMenuTree(String id) {
		List<MenuItem> list = new ArrayList<MenuItem>();
		if("#".equals(id)){
			list.add(getRootMenu());
			return list;
		}
		list = menuDao.queryMenuTreeChildren(id);
		return list;
	}
	
	private MenuItem getRootMenu(){
		MenuItem menu = new MenuItem();
		menu.setId("0");
        menu.setParent("#");
        menu.setText("根节点");
        menu.setSort(1);
        menu.setType("root");
        menu.setChildren(true);
        return menu;
	}

	@Override
	public Message addMenu(MenuItem menu) {
		Message msg = new Message();
		try{
			if(menuDao.isexist(menu)!=null){
				msg.setSuccess(true);
				msg.setMessage("添加失败:菜单ID" + menu.getId() + "-已存在于数据库中！");
				return msg;
			}
			menuDao.addMenu(menu);
			msg.setSuccess(true);
			msg.setMessage("添加成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("添加失败："+ ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message updateMenu(MenuItem menu) {
		Message msg = new Message();
		try{
			menuDao.updateMenu(menu);
			msg.setSuccess(true);
			msg.setMessage("修改成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("修改失败："+ ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message deleteMenu(String id) {
		Message msg = new Message();
		try{
			menuDao.deleteMenu(id);
			msg.setSuccess(true);
			msg.setMessage("删除成功");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("删除失败："+ ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public PagingGrid getMenuRoleByMenuId(String menuId) {
		List<Role> rows = menuDao.getMenuRoleByMenuId(menuId);
		return new PagingGrid(rows.size(), rows);
	}

	@Override
	public Message saveMenuRole(String menuId, String roleIds) {
		Message msg = new Message();
		try{
			List<String> list = StringUtils.strToListBySplit(roleIds, ",");
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("menuId", menuId);
			param.put("list", list);
			menuDao.deleteMenuRole(menuId);
			if(list.size()>0 && !"".equals(list.get(0))){
				menuDao.addMenuRole(param);
			}
			msg.setSuccess(true);
			msg.setMessage("保存成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("保存失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public PagingGrid queryFunByMenuId(int menuId, int offset, int limit) {
		List<Fun> list = menuDao.queryFunByMenuId(menuId, offset, limit);
		return new PagingGrid(list.size(), list);
	}

	@Override
	public Message addMenuFun(Fun fun) {
		Message msg = new Message();
		try{
			if(menuDao.isexistFun(fun)!=null){
				msg.setSuccess(false);
				msg.setMessage("已存在功能ID为:"+fun.getFunId()+"的数据");
				return msg;
			}
			menuDao.addMenuFun(fun);
			msg.setSuccess(true);
			msg.setMessage("添加成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("添加失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message updateMenuFun(Fun fun) {
		Message msg = new Message();
		try{
			menuDao.updateMenuFun(fun);
			msg.setSuccess(true);
			msg.setMessage("修改成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("修改失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public Message deleteMenuFun(String funIds) {
		Message msg = new Message();
		try{
			List<String> list = StringUtils.strToListBySplit(funIds, ",");
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("list", list);
			for (String str : list) {
				System.out.println("删除的元素：==== "+str);
			}
			menuDao.deleteMenuFun(param);
			msg.setSuccess(true);
			msg.setMessage("删除成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("删除失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

	@Override
	public PagingGrid getFunRoleByfunId(int funId, int offset, int limit) {
		List<Role> list = menuDao.getFunRoleByfunId(funId, offset, limit);
		return new PagingGrid(list.size(),list);
	}

	@Override
	public Message saveFunRole(int funId, String roleIds) {
		Message msg = new Message();
		try{
			List<String> list = StringUtils.strToListBySplit(roleIds, ",");
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("funId", funId);
			param.put("list", list);
			menuDao.deleteFunRole(funId);
			if(list.size()>0 && !"".equals(list.get(0))){
				menuDao.addFunRole(param);
			}
			msg.setSuccess(true);
			msg.setMessage("保存成功!");
		}catch(Exception e){
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage("保存失败:"+ExceptionDealUtil.getMessage(e));
		}
		return msg;
	}

}


