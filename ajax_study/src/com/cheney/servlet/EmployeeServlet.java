package com.cheney.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import com.cheney.bean.Department;
import com.cheney.bean.Employee;
import com.cheney.bean.Location;
import com.cheney.dao.BaseDao;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		
		try {
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private BaseDao baseDao=new BaseDao();
	
	protected void listLocations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("???");
		String sql="SELECT location_id locationId,city FROM locations";
		List<Location> locations=baseDao.getForList(sql, Location.class);
		System.out.println(locations);
		request.setAttribute("locations", locations);
		
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
	}
	
	protected void listDepartments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locationId=request.getParameter("locationId");
		String sql="SELECT department_id departmentId,department_name departmentName FROM departments d WHERE d.location_id=?";
		List<Department> departments=baseDao.getForList(sql, Department.class, Integer.parseInt(locationId));
		JSON result=JSONSerializer.toJSON(departments);
		System.out.println(result);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
	
	protected void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentId=request.getParameter("departmentId");
		String sql="SELECT employee_id employeeId,last_name lastName FROM employees e WHERE e.department_id=?";
		List<Employee> employees=baseDao.getForList(sql, Employee.class, Integer.parseInt(departmentId));
		JSON result=JSONSerializer.toJSON(employees);
		System.out.println(result);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
	protected void information(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId=request.getParameter("employeeId");
		String sql="SELECT employee_id employeeId,last_name lastName,email,salary FROM employees e WHERE e.employee_id=?";
		Employee employee=baseDao.get(sql, Employee.class, Integer.parseInt(employeeId));
		JSON result=JSONSerializer.toJSON(employee);
		System.out.println(result);
		
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
