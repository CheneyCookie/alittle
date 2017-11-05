package jdbc.day01.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCFactory {

	public static Connection getConnection() throws FileNotFoundException,
			IOException, ClassNotFoundException, SQLException {
		Connection conn = null;
		File file = new File("src/jdbc/day01/homework/jdbc_homework.properties");
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));

		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void update(String sql) {

		Connection conn = null;
		Statement statement = null;
		try {
			conn = getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			release(conn, statement, null);
		}

	}

	

	public static void release(Connection conn, Statement statement, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
