package com.cheney.bean;

public class Employee {

	private Integer employeeId;
	private String lastName;
	private String email;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String lastName, String email,
			double salary) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", lastName=" + lastName
				+ ", email=" + email + ", salary=" + salary + "]";
	}

}
