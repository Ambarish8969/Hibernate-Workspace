package com.employee2;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteEmployee {
	public void deleteEmployee() {
		Scanner ip=new Scanner(System.in);
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.out.println("Enter Employee Id : ");
		int id = ip.nextInt();

		Employee employee = entityManager.find(Employee.class, id);

		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		
		System.out.println("Employee deleted successfully.");
	}
}
