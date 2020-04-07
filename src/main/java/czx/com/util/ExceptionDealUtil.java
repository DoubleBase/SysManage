/**
 * Filename:	ExceptionDealUtil.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		yss
 * @Version:	1.0
 * Create time:	2017年6月19日 下午4:10:33
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年6月19日	yss			1.0				1.0 version
 */
package czx.com.util;

/**
 * @ClassName: ExceptionDealUtil
 * @Description:
 * @author: <a href="mailto:czx@eastcom.com">Yangss</a>
 * @date 2017年6月19日 下午4:10:33
 * 
 */
public class ExceptionDealUtil
{

    public static String getMessage(Exception e)
    {
        if (e.getMessage() == null)
        {
            return "系统出现异常,请联系管理员或重试!";
        } else
        {
            return e.getMessage().replaceAll("\n", " ");
        }
    }

}
