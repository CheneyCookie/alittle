package jdbc.day01.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void testCRUD() {
		String insertSql = null;
		for (int i = 1; i < 11; i++) {
			insertSql = "insert into t_student(id,name,age) values(" + i
					+ ",'tom',18)";
			JDBCFactory.update(insertSql);
		}

		String updateSql = "update t_student set name='张三' where id=2";
		JDBCFactory.update(updateSql);

		String deleteSql = "delete from t_student where id=5";
		JDBCFactory.update(deleteSql);

		String querySql = "select * from t_student";
		query(querySql);

	}
	
	@Test
	public void testFindAll(){
		List<Student> students=findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testSaveAll(){
		List<Student> students=new ArrayList<Student>();
		Student s1=new Student(101,"tom",18);
		Student s2=new Student(102,"jack",18);
		Student s3=new Student(103,"aaa",18);
		Student s4=new Student(104,"bbb",18);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		saveAll(students);
	}

	public static void query(String sql) {

		ResultSet rs = null;
		Connection conn = null;
		Statement statement = null;
		try {
			conn = JDBCFactory.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("id:" + rs.getInt(1) + ",name:"
						+ rs.getString(2) + ",age:" + rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JDBCFactory.release(conn, statement, rs);
		}

	}

	public List<Student> findAll() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		ResultSet rs = null;
		Connection conn = null;
		Statement statement = null;

		String sql = "select * from t_student";

		try {
			conn = JDBCFactory.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JDBCFactory.release(conn, statement, rs);
		}

		return students;
	}

	public void saveAll(List<Student> students) {
		String sql = null;
		for (Student student : students) {
			sql = "insert into t_student(id,name,age) values("
					+ student.getId() + "," + "'"+student.getName()+"'" + ","
					+ student.getAge() + ")";
			System.out.println(sql);
			JDBCFactory.update(sql);
		}
	}

	/*
	 * @Test public void test(){ String insertSql =
	 * "insert into t_student(id,name,age) values(1,'tom',18)";
	 * JDBCFactory.update(insertSql); }
	 */

}
