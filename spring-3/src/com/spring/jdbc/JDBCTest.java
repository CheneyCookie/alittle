package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

	private ApplicationContext ctx=null;
	private JdbcTemplate jdbcTemplate;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	/*
	 * 获取单个列的值，或做统计查询
	 * 使用queryForObject(String sql, Class<Long> requiredType)
	 * */
	@Test
	public void testQueryForObject2(){
		String sql="select count(ID) from employee";
		long count=jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	/*
	 * 查到实体类的集合
	 * 注意不是调用queryForList()方法	 
	 * */
	@Test
	public void testQueryForList(){
		String sql="select ID,NAME name,EMAIL from employee where ID>?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employee=jdbcTemplate.query(sql, rowMapper,5);
		System.out.println(employee);
	}
	
	/*
	 * 从数据库中获取一条记录，实际得到对应的一个对象
	 * 注意不是调用queryForObject(String sql, Class<Employee> requiredType, Object... args)方法
	 * 而需要调用queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args) 
	 * 1.其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2.使用SQL中列的别名完成列名和类的属性名映射，例如NAME name
	 * 不支持级联属性，JdbcTemplate到底 是一个JDBC小工具，而不是ORM框架
	 * */
	@Test
	public void testQueryForObject(){
		String sql="select ID,NAME name,EMAIL from employee where ID=?";
//		Employee employee=jdbcTemplate.queryForObject(sql,Employee.class,1);
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee=jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(employee);
	}
	
	/*
	 * 执行批量更新：批量的insert,update,delete
	 * 最后一个参数是Object[]的List类型：因为修改一条记录需要一个Object数组。
	 * */
	@Test
	public void testBatchUpdate(){
		String sql="insert into employee(Name,EMAIL,DEPT_ID) values(?,?,?)";
		List<Object[]> batchArgs=new ArrayList<>();
		batchArgs.add(new Object[]{"AA","aa@atguigu.com",1});
		batchArgs.add(new Object[]{"BB","bb@atguigu.com",2});
		batchArgs.add(new Object[]{"CC","cc@atguigu.com",3});
		batchArgs.add(new Object[]{"DD","dd@atguigu.com",3});
		batchArgs.add(new Object[]{"EE","ee@atguigu.com",2});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/*
	 *执行update,insert,delete 
	 * */
	@Test
	public void testUpdate(){
		String sql="update employee set NAME=? where id=?";
		jdbcTemplate.update(sql,"Jack",5);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
