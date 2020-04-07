/**
 * Filename:	PagingGrid.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		yss
 * @Version:	1.0
 * Create time:	2017年6月9日 下午2:48:18
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年6月9日	yss			1.0				1.0 version
 */
package czx.com.bean;

import java.util.List;

/**
 * @ClassName: PagingGrid
 * @Description:
 * @author: <a href="mailto:czx@eastcom.com">Yangss</a>
 * @date 2017年6月9日 下午2:48:18
 * 
 */
public class PagingGrid
{

    private int total;

    private List<?> rows;

    public PagingGrid(int total, List<?> rows)
    {
        this.total = total;
        this.rows = rows;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

}
