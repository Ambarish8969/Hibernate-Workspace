package com.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=new Person();
		person1.setName("Ambika");
		person1.setAge(23);
		person1.setGender("Female");
		person1.setPhno(454444116);
		
		Person person2=new Person();
		person2.setName("Ambarish");
		person2.setAge(23);
		person2.setGender("Male");
		person2.setPhno(9900408969l);
		
		AdharCard adharCard1=new AdharCard();
		adharCard1.setId(4561321);
		adharCard1.setAddress("Basavanagudi");
		
		AdharCard adharCard2=new AdharCard();
		adharCard2.setId(7897988);
		adharCard2.setAddress("Banlgore");
		
		person1.setCard(adharCard1);
		person1.setCard(adharCard2);
		
		entityTransaction.begin();
//		entityManager.persist(person1);
//		entityManager.persist(person2);
		entityManager.persist(adharCard1);
		entityManager.persist(adharCard2);
		entityTransaction.commit();
	}
}
