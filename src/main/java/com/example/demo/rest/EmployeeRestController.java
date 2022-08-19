package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value = "/employees")
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployee();
	}

	@GetMapping(value = "/employees/{employeeId}")
	public Employee findEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee Id Not Found: " + employeeId);
		}

		return employee;
	}

	@PostMapping(value = "/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);

		employeeService.save(employee);

		return employee;
	}

	@PutMapping(value = "/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);

		return employee;
	}
	
	@DeleteMapping(value = "/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findEmployeeById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee Id Not Found: " + employeeId);
		}
		
		employeeService.deleteEmployeeById(employeeId);
		return "Employee Deleted: " + employeeId;
	}
}
