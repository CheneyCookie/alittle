package jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.day01.DriverFactory;

/**
 * 使用Statement测试安全注入问题
 * 
 * @author cheney
 *
 */
public class StudentSt {
	private static Connection conn;
	private static Statement stat;
	private static ResultSet rs;

	public static void main(String[] args) throws SQLException {
		conn = DriverFactory.getConnection();

		// 模拟前台传入的用户名、密码
		Student stu = new Student();
		stu.setName("tom");
		stu.setPassword("111");

		// 获取Statement对象
		stat = (Statement) conn.createStatement();

		String sql = "select * from student where name ='" + stu.getName()
				+ "' and password='" + stu.getPassword() + "'";
		// 执行sql语句
		System.out.println(sql);
		rs = stat.executeQuery(sql);
		// 处理结果集
		while (rs.next()) {
			System.out.println("id:" + rs.getInt("id") + ",name:"
					+ rs.getString("name") + ",password:"
					+ rs.getString("password") + ",age:" + rs.getInt("age")
					+ ",gender:" + rs.getString("gender"));
		}
		DriverFactory.getClose(conn, stat, rs);
	}
}
