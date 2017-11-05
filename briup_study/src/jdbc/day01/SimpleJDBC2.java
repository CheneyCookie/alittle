package jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC进行增删改查
 * @author cheney
 *
 */
public class SimpleJDBC2 {
	private static Connection connection;
	private static ResultSet rs;
	
	public static void main(String[] args) {
		connection = DriverFactory.getConnection();
		String iSql="insert into t_user values(1,'tom',1000)";
		String sSql="select * from t_user";
		String uSql="update t_user set name='jack'";
		String dSql="delete t_user";
		//插入
		insert(iSql);
		//查询
		select(sSql);
		
		//修改
		update(uSql);
		//查询
		select(sSql);
		
		//删除
		delete(dSql);
		//查询
		select(sSql);
	}
	
	public static void insert(String sql){
		try {
			//创建Statement对象
			Statement statement = connection.createStatement();
			
			//执行sql语句
			int i = statement.executeUpdate(sql);
			System.out.println("插入"+i+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//如果插入出错，回滚事务
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void select(String sql){
		try {
			Statement statement = connection.createStatement();
			
			rs = statement.executeQuery(sql);
			while(rs.next()){
				System.out.println("id:"+rs.getInt(1)+",name:"+rs.getString(2)+",salary:"+rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update(String sql){
		try {
			//创建Statement对象
			Statement statement = connection.createStatement();
			
			//执行sql语句
			int i = statement.executeUpdate(sql);
			System.out.println("修改"+i+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(String sql){
		try {
			//创建Statement对象
			Statement statement = connection.createStatement();
			
			//执行sql语句
			int i = statement.executeUpdate(sql);
			System.out.println("删除"+i+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
