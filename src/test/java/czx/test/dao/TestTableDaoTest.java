/**
 * Filename:	TestTableDaoTest.java
 * Description:	
 * Copyright:	Copyright (c) 2012-2017
 * Company:		HangZhou Eastcom Network Technology CO., Ltd
 * @Author:		czx
 * @Version:	1.0
 * Create time:	2017年11月7日 下午10:50:25
 * 
 * Modification History:
 * Date			Author			Version			Description
 * ------------------------------------------------------------------
 * 2017年11月7日	 czx			1.0				1.0 version
 */
package czx.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import czx.test.bean.TestTable;

/**  
 * @ClassName	TestTableDaoTest.java
 * @Package  	czx.test.dao
 * @Description TODO
 * @author    	<a href="mailto:czx@eastcom.com">czx</a>
 * @date 		2017年11月7日  下午10:50:25
 * @version V1.0  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestTableDaoTest {

	@Resource
	private TestTableDao dao;
	
	@Test
	public void test() {
		List<TestTable> list = dao.queryList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTestName());
		}
	}

}


