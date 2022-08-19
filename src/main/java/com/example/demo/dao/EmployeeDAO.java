package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAllEmployee();

	public Employee findEmployeeById(int id);

	public void save(Employee employee);

	public void deleteEmployeeById(int id);
}
