package mybatis.day03.classcode;

import java.util.List;
import java.util.Map;
import java.util.Set;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultmapperTest {

	@Test
	public void testFindAllStudent(){
		SqlSession session=MySqlSessionFactory.openSession();
		ResultMapper mapper = session.getMapper(ResultMapper.class);
		List<Student> students = mapper.findAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	@Test
	public void testFidStudent_Set(){
		SqlSession session=MySqlSessionFactory.openSession();
		ResultMapper mapper = session.getMapper(ResultMapper.class);
		Set<Student> students = mapper.findStudent_Set();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	@Test
	public void findStudentById_Map(){
		SqlSession session=MySqlSessionFactory.openSession();
		ResultMapper mapper = session.getMapper(ResultMapper.class);
		Map<String, Object> mapStudents = mapper.findStudentById_Map(4);
		for(String key:mapStudents.keySet()){
			System.out.println(key+":"+mapStudents.get(key));
		}
		session.close();
	}
	
	@Test
	public void findStudent_ListMap(){
		SqlSession session=MySqlSessionFactory.openSession();
		ResultMapper mapper = session.getMapper(ResultMapper.class);
		List<Map<String, Object>> mapListStudents = mapper.findStudent_ListMap();
		for(Map<String, Object> map:mapListStudents){
			for(String key:map.keySet()){
				System.out.println(key+":"+map.get(key));
			}
			System.out.println("---------");
		}
		session.close();
	}
}
