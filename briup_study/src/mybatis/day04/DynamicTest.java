package mybatis.day04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DynamicTest {
	SqlSession session;
	TutorMapper tMapper;
	CourseMapper cMapper;
	
	@Before
	public void init(){
		session=MySqlSessionFactory.openSession();
		tMapper=session.getMapper(TutorMapper.class);
		cMapper=session.getMapper(CourseMapper.class);
	}
	
	@After
	public void close(){
		session.close();
	}
	
	@Test
	public void testIf(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("courseId", 1); 
		map.put("courseName", "%A%"); 
		map.put("startDate", new Date()); 
		Course course = cMapper.selectCourseIf(map);
		System.out.println(course);
	}
	
	@Test
	public void testChoose(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tutorId", 1); 
		map.put("courseName", "%A%"); 
//		map.put("searchBy", "Tutor");
		map.put("searchBy", "CourseName");
		Course course = cMapper.selectCourseChoose(map);
		System.out.println(course);
	}
	
	
	@Test
	public void testWhere(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tutorId", 1); 
		map.put("courseName", "%A%");
		map.put("startDate", new Date());
		map.put("endDate", new Date());
		Course course = cMapper.selectCourseWhere(map);
		System.out.println(course);
	}
}
