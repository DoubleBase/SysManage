/**
 * Filename:	StringUtils.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月9日 下午1:27:38
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月9日	 czx			1.0				1.0 version
 */
package czx.com.util;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName	StringUtils.java
 * @Package  	czx.com.util
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月9日  下午1:27:38
 * @version V1.0  
 */
public class StringUtils {

	/**
     * 字符串转List
     * 
     * @param source
     * @param split
     * @return
     */
    public static List<String> strToListBySplit(String source, String split){
        List<String> dest = new ArrayList<String>();
        if (null == source)
            return dest;
        String[] arr = source.split(split);
        for (String s : arr){
            dest.add(s);
        }
        return dest;
    }
}


