package com.employee2;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetEmployee {
	public void getEmployee() {
		Scanner ip=new Scanner(System.in);
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();

		System.out.println("Enter Employee Id : ");
		int id = ip.nextInt();

		Employee employee = entityManager.find(Employee.class, id);

		System.out.println("Employee Id : " + employee.getId());
		System.out.println("Employee Name : " + employee.getName());
		System.out.println("Employee Age : " + employee.getAge());
		System.out.println("Employee Sal : " + employee.getSal());
	}
}
