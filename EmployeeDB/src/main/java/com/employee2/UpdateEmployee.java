package com.employee2;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmployee {
	public void updateEmployee() {
		Scanner ip = new Scanner(System.in);
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.out.println("Enter Employee Id : ");
		int id = ip.nextInt();

		Employee employee = entityManager.find(Employee.class, id);

		System.out.println("Enter Employee Name : ");
		String name = ip.next();
		System.out.println("Enter Employee Age : ");
		int age = ip.nextInt();
		System.out.println("Enter Employee Name : ");
		int sal = ip.nextInt();

		employee.setName(name);
		employee.setAge(age);
		employee.setSal(sal);

		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
		System.out.println("Employee updated successfully.");
	}
}
