package com.manytomany1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person p1=new Person();
		p1.setName("Ambarish");
		p1.setPhno(9900408969l);
		
		Person p2=new Person();
		p2.setName("Ambika");
		p2.setPhno(798795446);
		
		Person p3=new Person();
		p3.setName("Rakesh");
		p3.setPhno(465413216);
		
		Cab c1=new Cab();
		c1.setDname("Driver 1");
		c1.setCost(500);
		
		Cab c2=new Cab();
		c2.setDname("Driver 2");
		c2.setCost(600);
		
		Cab c3=new Cab();
		c3.setDname("Driver 3");
		c3.setCost(499);
		
		Cab c4=new Cab();
		c4.setDname("Driver 4");
		c4.setCost(300);
		
		List<Cab> list1=new ArrayList<Cab>();
		list1.add(c1);
		list1.add(c3);
		
		List<Cab> list2=new ArrayList<Cab>();
		list2.add(c3);
		list2.add(c4);
		
		p1.setCabs(list1);
		p2.setCabs(list2);
		p3.setCabs(list2);
		
		entityTransaction.begin();
//		entityManager.persist(p1);
//		entityManager.persist(p2);
		entityManager.persist(p3);
//		entityManager.persist(c1);
//		entityManager.persist(c2);
//		entityManager.persist(c3);
		entityTransaction.commit();
	}
}
