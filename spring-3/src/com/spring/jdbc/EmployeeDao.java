package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee get(Integer id){
		String sql="select ID,NAME,EMAIL from employee where id=?";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee=jdbcTemplate.queryForObject(sql, rowMapper,id);
		return employee;
	}
}
