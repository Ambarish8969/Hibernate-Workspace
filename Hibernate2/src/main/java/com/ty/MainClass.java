package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person1 = new Person();
		person1.setId(101);
		person1.setName("Ambarish");
		person1.setAge(23);
		person1.setGender("Male");
		person1.setPhno(9900408969l);
		
		Person person2 = new Person();
		person2.setId(102);
		person2.setName("Ambika");
		person2.setAge(23);
		person2.setGender("Female");
		person2.setPhno(9900401235l);
		
		Person person3 = new Person();
		person3.setId(103);
		person3.setName("Aishwarya");
		person3.setAge(23);
		person3.setGender("Female");
		person3.setPhno(9900401235l);
		
		Person person4 = new Person();
		person4.setId(104);
		person4.setName("Akash");
		person4.setAge(23);
		person4.setGender("Male");
		person4.setPhno(9900401235l);
		
		Person person5 = new Person();
		person5.setId(105);
		person5.setName("Nisha");
		person5.setAge(23);
		person5.setGender("Female");
		person5.setPhno(9900401235l);

		entityTransaction.begin();
//		entityManager.persist(person1);
//		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.persist(person4);
		entityManager.persist(person5);
		entityTransaction.commit();
	}
}
