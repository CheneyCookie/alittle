package jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.day01.DriverFactory;

/**
 * 测试JDBC批处理
 * @author cheney
 *
 */
public class BatchTest {
	private static Connection conn;
	private static Statement stat;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		conn=DriverFactory.getConnection();
		/*
		//使用Statement进行批处理
		//适用于结构不同的sql语句
		stat=conn.createStatement();
		String sql1="insert into batch values(1,'tom')";
		String sql2="update batch set id=2";
		String sql3="insert into batch values(3,'jack')";
		//将sql语句添加到缓存中
		stat.addBatch(sql1);
//		stat.addBatch(sql2);
		stat.addBatch(sql3);
		//执行(缓存中的内容)批处理
		stat.executeBatch();*/
		
		//使用PreparementStatement进行批处理
		String sql="insert into batch values(?,?)";
		pstmt=conn.prepareStatement(sql);
		for (int i = 0; i < 50000; i++) {
			pstmt.setInt(1, i);
			pstmt.setString(2, "a"+i);
			pstmt.addBatch(sql);
			if(i%5000==0){
				pstmt.executeBatch();
				//清空缓存
				pstmt.clearBatch();
			}
		}
	}
}
