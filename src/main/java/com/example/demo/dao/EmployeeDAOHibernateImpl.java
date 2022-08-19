package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAllEmployee() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

}
