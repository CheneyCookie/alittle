package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DepartemtDao extends JdbcDaoSupport{
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public Department get(int id){
		String sql="Select id,dept_name name from departments where id=?";
		RowMapper<Department> rowMapper=new BeanPropertyRowMapper<Department>(Department.class);
		Department department = getJdbcTemplate().queryForObject(sql, rowMapper,id);
		return department;
		
	}
}
