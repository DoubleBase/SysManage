/**
 * Filename:	PagingParam.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		yss
 * @Version:	1.0
 * Create time:	2017年7月25日 下午3:40:29
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年7月25日	yss			1.0				1.0 version
 */
package czx.com.bean;

/**
 * @ClassName: PagingParam
 * @Description:
 * @author: <a href="mailto:yss@eastcom.com">Yangss</a>
 * @date 2017年7月25日 下午3:40:29
 * 
 */
public class PagingParam
{

    private int offset;
    private int limit;
    private String sortName;
    private String sortOrder;

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public String getSortName()
    {
        return sortName;
    }

    public void setSortName(String sortName)
    {
        this.sortName = sortName;
    }

    public String getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder)
    {
        this.sortOrder = sortOrder;
    }

}
