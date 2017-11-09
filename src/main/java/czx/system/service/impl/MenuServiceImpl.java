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
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.com.bean.Message;
import czx.com.util.ExceptionDealUtil;
import czx.system.bean.Menu;
import czx.system.bean.MenuItem;
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
	public List<Menu> queryMenuList() {
		return Menu.toTreeNode(menuDao.queryMenuList(), 0);
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

}


