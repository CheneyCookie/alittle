package mybatis.day01.homework.work1.test;


import java.util.List;

import mybatis.day01.homework.work1.mappers.StudentMapper;
import mybatis.day01.homework.work1.pojo.Student;
import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentTest {


	@Test
	public void testAdd() {
		SqlSession sqlSession=MySqlSessionFactory.openSession();
		Student student=new Student(3,"jack",22);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		studentMapper.add(student);
		sqlSession.commit();
	}
	@Test
	public void testDelete() {
		SqlSession sqlSession=MySqlSessionFactory.openSession();
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		studentMapper.deleteById(3);
		sqlSession.commit();
	}
	@Test
	public void testUpdate() {
		SqlSession sqlSession=MySqlSessionFactory.openSession();
		Student student=new Student(2,"jac",17);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		studentMapper.update(student);
		sqlSession.commit();
	}
	@Test
	public void testQuery() {
		SqlSession sqlSession=MySqlSessionFactory.openSession();
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.queryById(2);
		System.out.println(student);
	}
	
	@Test
	public void testQueryAll() {
		SqlSession sqlSession=MySqlSessionFactory.openSession();
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		List<Student> students=studentMapper.queryAll();
		System.out.println(students);
	}

}
