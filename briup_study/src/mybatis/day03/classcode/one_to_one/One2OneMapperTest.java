package mybatis.day03.classcode.one_to_one;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class One2OneMapperTest {

	@Test
	public void testFindStudentById_1(){
		SqlSession session=MySqlSessionFactory.openSession();
		One2OneMapper mapper = session.getMapper(One2OneMapper.class);
		Student student = mapper.findStudentById_1(1);
		System.out.println(student);
	}
	
}
