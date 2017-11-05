package jdbc.day01;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装jdbc前2步
 * 
 * @author cheney
 *
 */
public class DriverFactory {
	private static Properties prop;
	private static String driver;
	private static String url;
	private static String name;
	private static String pwd;
	private static Connection connection;

	static {
		File file = new File("src/jdbc/day01/jdbc.properties");
		// System.out.println(file.exists());
		try {
			prop = new Properties();
			// 将保存数据的文件，读取到prop对象里
			prop.load(new FileInputStream(file));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			name = prop.getProperty("user");
			pwd = prop.getProperty("password");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 返回连接对象
	public static Connection getConnection() {
		try {
			// 1.获取驱动
			Class.forName(driver);
			// 2.获取连接对象
			connection = DriverManager.getConnection(url, name, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭资源
	public static void getClose(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
