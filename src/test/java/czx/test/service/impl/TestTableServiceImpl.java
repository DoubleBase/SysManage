/**
 * Filename:	TestTableServiceImpl.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月7日 下午10:46:40
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月7日	 czx			1.0				1.0 version
 */
package czx.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import czx.test.bean.TestTable;
import czx.test.dao.TestTableDao;
import czx.test.service.TestTableService;

/**  
 * @ClassName	TestTableServiceImpl.java
 * @Package  	czx.test.service.impl
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月7日  下午10:46:40
 * @version V1.0  
 */
@Scope("prototype")
@Service
public class TestTableServiceImpl implements TestTableService {

	@Resource
	private TestTableDao dao;
	
	@Override
	public List<TestTable> queryList() {
		return dao.queryList();
	}

}


