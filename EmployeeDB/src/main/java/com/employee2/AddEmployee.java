package com.employee2;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddEmployee {

	public void addEmployee() {
		Scanner ip = new Scanner(System.in);

		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee e1 = new Employee();

		System.out.println("Enter Employee Name : ");
		String name = ip.next();
		System.out.println("Enter Employee Age : ");
		int age = ip.nextInt();
		System.out.println("Enter Employee Salary : ");
		int sal = ip.nextInt();

		e1.setName(name);
		e1.setAge(age);
		e1.setSal(sal);

		entityTransaction.begin();
		entityManager.persist(e1);
		entityTransaction.commit();
		
		System.out.println("Employee added successfully.");
	}
}
