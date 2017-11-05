package mybatis.day03.homework.work2;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnetoManyTest {
	SqlSession session;
	OneToManyMapper mapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		mapper=session.getMapper(OneToManyMapper.class);
	}
	
	@After
	public void close(){
		session.close();
	}
	
	@Test
	public void testSelectUser(){
		User user = mapper.selectUser(1);
		System.out.println(user);
	}
	
	@Test
	public void testSelectGroup(){
		Group group = mapper.selectGroup(1);
		Group group2 = mapper.selectGroup(2);
		Group group3 = mapper.selectGroup(3);
		System.out.println(group);
		System.out.println(group2);
		System.out.println(group3);
	}
	
	@Test
	public void testAddGroup(){
		Group group=new Group();
		group.setId(3);
		group.setName("GGG");
		mapper.addGroup(group);
		session.commit();
		
	}
	
	@Test
	public void testAddUser(){
		Group group=new Group();
		group.setId(3);
		User user=new User(6,"II",group);
		mapper.addUser(user);
		session.commit();
	}
}
