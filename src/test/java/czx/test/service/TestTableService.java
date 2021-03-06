/**
 * Filename:	TestTableService.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月7日 下午10:45:45
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月7日	 czx			1.0				1.0 version
 */
package czx.test.service;

import java.util.List;

import czx.test.bean.TestTable;

/**  
 * @ClassName	TestTableService.java
 * @Package  	czx.test.service
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月7日  下午10:45:45
 * @version V1.0  
 */
public interface TestTableService {

	public List<TestTable> queryList();
}


