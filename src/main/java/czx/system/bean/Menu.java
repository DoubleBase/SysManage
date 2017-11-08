/**
 * Filename:	Menu.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月8日 下午3:36:16
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月8日	 czx			1.0				1.0 version
 */
package czx.system.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName	Menu.java
 * @Package  	czx.system.bean
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月8日  下午3:36:16
 * @version V1.0  
 */
public class Menu {

	private int id;
	private int pid;
	private String text;
	private String url;
	private String icon;
	private String targetType;
	private int sort;
	private String isHeader;
	private List<Menu> children = new LinkedList<Menu>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getIsHeader() {
		return isHeader;
	}
	public void setIsHeader(String isHeader) {
		this.isHeader = isHeader;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		for (Menu menu : children) {
			if(this.id==menu.getPid()){
				this.children.add(menu);
				menu.setChildren(children);
			}
		}
	}
	
	public static List<Menu> toTreeNode(List<Menu> list,int pid){
		List<Menu> listTemp = new ArrayList<Menu>();
		for (Menu menu : list) {
			if(menu.getPid()==pid){
				menu.setChildren(list);
				listTemp.add(menu);
			}
		}
		return listTemp;
	}
	
}


