package mybatis.day02.classcode;

import java.util.Date;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentTest {

	@Test
	public void testAdd() {
		SqlSession sqlSession = MySqlSessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		PhoneNumber phone = new PhoneNumber("110", "119", "120");
		Student stu = new Student(1, "rose", "1124@qq.com", new Date(), phone);

		studentMapper.add(stu);
		sqlSession.commit();
	}

	@Test
	public void testInsertWithId() {
		try {
			SqlSession session = null;
			session = MySqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			PhoneNumber phone=new PhoneNumber("111","222","333");
			Student stu=new Student("tom","123@qq.com",new Date(), phone);
			System.out.println(stu);
			mapper.insertWithId(stu);
			System.out.println(stu);
			session.commit();
			System.out.println(stu);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
