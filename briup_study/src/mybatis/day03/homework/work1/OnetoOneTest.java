package mybatis.day03.homework.work1;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnetoOneTest {
	SqlSession session;
	OnetoOneMapper mapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		mapper=session.getMapper(OnetoOneMapper.class);
	}
	
	@After
	public void close(){
		session.close();
	}
	
	
	@Test
	public void testAddWife(){
		Husband husband=new Husband(2,"BB",18);
		Wife wife=new Wife(2, "BBW", 18, husband);
		mapper.addHusband(husband);
		mapper.addWife(wife);
		session.commit();
	}
	
	
	@Test
	public void testSelectHusband(){
		Husband husband = mapper.selectHusband(1);
		System.out.println(husband);
	}
	
	@Test
	public void testSelectWife(){
		Wife wife = mapper.selectWife(1);
		System.out.println(wife);
	}
}
