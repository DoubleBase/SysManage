/**
 * Filename:	MenuTree.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		Hx
 * @Version:	1.0
 * Create time:	2017年7月5日 上午9:45:53
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年7月5日	Hx			1.0				1.0 version
 */
package czx.system.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @ClassName:		MenuTree
 * @Description:	
 * @author:			<a href="mailto:czx@eastcom.com">huangxiang</a>
 * @date			2017年7月5日 上午9:45:53
 * 
 */
public class MenuTree
{
    private String id;
    private String pid;
    private String text;
    private String icon;
    private String url;
    private String checked;
    private int sort;
    private TreeState state;
    private List<MenuTree> children = new LinkedList<MenuTree>();

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
        TreeState state = new TreeState();
        if ("true".equals(checked)) {
            state.setSelected(true);
        } else {
        	state.setSelected(false);
        }
        setState(state);
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public List<MenuTree> getChildren() {
		return children;
	}

	public TreeState getState() {
		return state;
	}

	public void setState(TreeState state) {
		this.state = state;
	}

	public void setChildren(List<MenuTree> subMenus) {
		for (MenuTree menuItem : subMenus) {
            if (this.id .equals(menuItem.getPid()) ) {
                this.children.add(menuItem);
                menuItem.setChildren(subMenus);
            }
        }
	}

    public static List<MenuTree> toTreeNode(List<MenuTree> list, String pid) {
        List<MenuTree> listTemp = new ArrayList<MenuTree>();
        for (MenuTree menuItem : list) {
            if (pid .equals(menuItem.getPid())) {
                menuItem.setChildren(list);
                listTemp.add(menuItem);
            }
        }
        return listTemp;
    }

}
