package com.employee2;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import customexceptions.InvalidIDFoundExcepiton;

public class GetEmployee {
	public void getEmployee() {
		Scanner ip = new Scanner(System.in);
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();

		System.out.println("Enter Employee Id : ");
		int id = ip.nextInt();

		Employee employee = entityManager.find(Employee.class, id);
		Query query = entityManager.createQuery("select e.id from Employee e");

		List<Integer> id_list = query.getResultList();

		if (id_list.contains(id)) {
			System.out.println("---------------------------------------");
			System.out.println("Employee Id : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Employee Age : " + employee.getAge());
			System.out.println("Employee Sal : " + employee.getSal());
			System.out.println("---------------------------------------");
		} else {
			try {
				throw new InvalidIDFoundExcepiton("ID not found in Database. Please enter valid ID");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
