package mybatis.day03.homework.improve1;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnetoOneTest {
	SqlSession session;
	HusbandMapper hMapper;
	WifeMapper wMapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		 hMapper=session.getMapper(HusbandMapper.class);
		 wMapper=session.getMapper(WifeMapper.class);
	}
	
	@After
	public void commAndClose(){
		session.commit();
		session.close();
	}
	
	
	@Test
	public void testAddWife(){
		Husband husband=new Husband();
		husband.setId(3);
		Wife wife=new Wife(3, "CCW", 1, husband);
		wMapper.addWife(wife);
	}
	
	
	@Test
	public void testAddHusband(){
		Husband husband=new Husband(3, "CC", 18);
		hMapper.addHusband(husband);
	}
	
	
	@Test
	public void testSelectHusband(){
		Husband husband=hMapper.selectHusband(1);
		System.out.println(husband);
	}
	
	@Test
	public void testSelectWife(){
		Wife wife = wMapper.selectWife(1);
		System.out.println(wife);
	}
}
