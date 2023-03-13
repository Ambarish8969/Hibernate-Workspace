package com.employee2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllEmployee {
	public void getAllEmployees() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("select e from Employee e");

//		Query query=entityManager.createQuery("select s from Student2 s where s.age<?1");
//		query.setParameter(1, 50);

		List<Employee> employees = query.getResultList();

		for (Employee employee : employees) {
			System.out.println("Employee Id : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Employee Age : " + employee.getAge());
			System.out.println("Employee Sal : " + employee.getSal());
			System.out.println("----------------------------------------");
		}
	}
}
