package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAllEmployee() {
		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> resultList = theQuery.getResultList();
		return resultList;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee theEmployee = entityManager.find(Employee.class, id);

		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		Employee theEmployee = entityManager.merge(employee);
		employee.setId(theEmployee.getId());
	}

	@Override
	public void deleteEmployeeById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}
}
