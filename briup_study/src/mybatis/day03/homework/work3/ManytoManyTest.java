package mybatis.day03.homework.work3;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManytoManyTest {
	SqlSession session;
	ManyToManyMapper mapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		mapper=session.getMapper(ManyToManyMapper.class);
	}
	
	@After
	public void close(){
		session.close();
	}
	
	@Test
	public void testInsertStudent(){
		Student student=new Student();
		student.setName("CCCC");
		mapper.insertStudent(student);
		session.commit();
	}
	
	@Test
	public void testInsertTeacher(){
		Teacher teacher=new Teacher();
		teacher.setName("DDDD");
		mapper.insertTeacher(teacher);
		session.commit();
	}
	
	@Test
	public void testInsertBridge(){
		Student student = mapper.selectStudent(21);
		Teacher teacher = mapper.selectTeacher(1);
		System.out.println(student);
		System.out.println(teacher);
		mapper.insertBridge(student, teacher);
		session.commit();
	}
	
	@Test
	public void testSelectStudentWithTea(){
		Student student = mapper.selectStudentWithTea(2);
		System.out.println(student);
	}
	
	@Test
	public void testSelectTeacherWithStu(){
		Teacher teacher=mapper.selectTeacherWithStu(1);
		System.out.println(teacher);
	}
	
}
