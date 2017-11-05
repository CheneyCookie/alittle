package jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.day01.DriverFactory;

/**
 * 使用PreparedStatement测试sql注入
 * 
 * @author cheney
 *
 */
public class StudentPs {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static void main(String[] args) throws SQLException {
		// 获取连接对象
		conn = DriverFactory.getConnection();
		// 模拟前台传入数据
		Student stu = new Student();
		stu.setName("rose");
		stu.setPassword("22");

		// 创建PrepareStatment对象
		String sql = "select * from student where name=? and password=?";
		//1.对象创建的时候，就需要传入sql语句，起预编译的功能
		pstmt = conn.prepareStatement(sql);
		//完善sql语句
		/**
		 * 第一个参数：sql语句中第几个?占位符，index从1开始
		 * 第二个参数：要传入的值，要与set方法的数据类型匹配
		 */
		pstmt.setString(1, stu.getName());
		pstmt.setString(2,stu.getPassword());
		//执行sql语句
		rs=pstmt.executeQuery();
		//处理结果集
		while (rs.next()) {
			System.out.println("id:" + rs.getInt("id") + ",name:"
					+ rs.getString("name") + ",password:"
					+ rs.getString("password") + ",age:" + rs.getInt("age")
					+ ",gender:" + rs.getString("gender"));
		}
		//关闭资源
		DriverFactory.getClose(conn, pstmt, rs);
	}
}
