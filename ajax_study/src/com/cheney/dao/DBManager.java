package com.cheney.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import javax.swing.DefaultButtonModel;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	private static DataSource dataSource;
	
	//数据库连接池只被初始化一次
	static{
		dataSource=new ComboPooledDataSource("ajaxApp");
	}

	/*
	 * 获取数据库连接的方法
	 */
	public static Connection getConnection() throws IOException,
			ClassNotFoundException, SQLException {
		return dataSource.getConnection();
	}

	private DBManager(){}
	
	private static DBManager instance=new DBManager();
	
	public static DBManager getInstance(){
		return instance;
	}
	
	
			
	
	
}
