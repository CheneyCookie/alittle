package mybatis.day03.homework.improve2;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnetoManyTest {
	SqlSession session;
	UserMapper uMapper;
	GroupMapper gMapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		uMapper=session.getMapper(UserMapper.class);
		gMapper=session.getMapper(GroupMapper.class);
	}
	
	@After
	public void close(){
		session.commit();
		session.close();
	}
	
	@Test
	public void testSelectUser(){
		User user = uMapper.selectUser(7);
		System.out.println(user);
	}
	
	@Test
	public void testSelectGroup(){
		Group group=gMapper.selectGroup(4);
		System.out.println(group);
	}
	
	@Test
	public void testAddGroup(){
		Group group=new Group();
		group.setId(4);
		group.setName("JJJ");
		gMapper.addGroup(group);
	}
	
	@Test
	public void testAddUser(){
		Group group=new Group();
		group.setId(4);
		User user=new User(8, "LL", group);
		uMapper.addUser(user);
	}
}
