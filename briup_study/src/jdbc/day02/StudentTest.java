package jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.day01.DriverFactory;

/**
 * 使用PreparedStatement进行增删改查
 * 
 * @author cheney
 *
 */
public class StudentTest {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static void main(String[] args) {
		conn = DriverFactory.getConnection();

		Student stu = new Student(4, "lisi", "44", 30, "male");
		// 测试
		// getInsert(stu);
		// getSelect(stu);
		getUpdate(18);
		getSelect(stu);
		getDelete();
	}

	// 插入
	private static void getInsert(Student stu) {
		try {
			String sql = "insert into student values(stu_seq.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, stu.getId());
			pstmt.setString(1, stu.getName());
			pstmt.setString(2, stu.getPassword());
			pstmt.setInt(3, stu.getAge());
			pstmt.setString(4, stu.getGender());
			int i = pstmt.executeUpdate();
			System.out.println("插入:" + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}/*
		 * finally{ DriverFactory.getClose(conn, pstmt, rs); }
		 */
	}

	// 查询
	private static void getSelect(Student stu) {
		String sql = "select * from student where name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("id:" + rs.getInt("id") + ",name:"
						+ rs.getString("name") + ",password:"
						+ rs.getString("password") + ",age:" + rs.getInt("age")
						+ ",gender:" + rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 修改
	public static void getUpdate(int age) {
		String sql = "update student set age=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			int i = pstmt.executeUpdate();
			System.out.println("更改：" + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除
	public static void getDelete() {
		String sql = "delete student";
		try {
			pstmt = conn.prepareStatement(sql);
			int i = pstmt.executeUpdate();
			System.out.println("删除完成");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DriverFactory.getClose(conn, pstmt, rs);
		}
	}
}
