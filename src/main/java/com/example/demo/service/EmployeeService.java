package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployee();

	public Employee findEmployeeById(int id);

	public void save(Employee employee);

	public void deleteEmployeeById(int id);
}
