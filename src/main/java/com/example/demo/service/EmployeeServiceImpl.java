package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

//	in case of Spring Data JPA and add default method and that's it.
//	and you also don't need to provide transactional since that is taken care by Spring Data JPA

//	private EmployeeRepository employeeRepository;
//
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		return employeeDAO.findAllEmployee();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		return employeeDAO.findEmployeeById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
	}

}
