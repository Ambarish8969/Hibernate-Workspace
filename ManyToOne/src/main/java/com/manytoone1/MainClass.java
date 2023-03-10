package com.manytoone1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student s1=new Student();
		s1.setName("Ambika");
		s1.setAge(23);
		s1.setMarks(99);
		s1.setGender("Female");
		
		Student s2=new Student();
		s2.setName("Ambarish");
		s2.setAge(24);
		s2.setMarks(89);
		s2.setGender("Male");
		
		College c1=new College();
		c1.setName("KLE College of Engineering and Technology, Chikodi.");
		c1.setWebsite("www.klecet.edu.in");
		c1.setLocation("Chikodi");
		
		s1.setColleges(c1);
		s2.setColleges(c1);
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(c1);
		entityTransaction.commit();
	}
}
