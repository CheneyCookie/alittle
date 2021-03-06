package com.cheney.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheney.springmvc.crud.entities.Department;
import com.cheney.springmvc.crud.entities.Employee;

@Repository
public class EmployeeDao {
	private static Map<Integer,Employee> employees=null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees=new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "E-AA",  "aa@qq.com", "0", new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB",  "bb@qq.com", "0", new Department(101, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC",  "cc@qq.com", "1", new Department(101, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD",  "dd@qq.com", "1", new Department(101, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE",  "ee@qq.com", "1", new Department(101, "D-EE")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
