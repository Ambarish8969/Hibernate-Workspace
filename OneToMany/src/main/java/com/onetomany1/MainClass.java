package com.onetomany1;

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
		
		Mobile m1=new Mobile();
		m1.setBrand("iPhone");
		m1.setCost(100000);
		m1.setColor("Black");
		m1.setRam(4);
		
		Mobile m2=new Mobile();
		m2.setBrand("Samsung");
		m2.setCost(10000);
		m2.setColor("White");
		m2.setRam(8);
		
		Sim s1=new Sim();
		s1.setSim_name("Jio");
		s1.setSim_network_type("4g");
		s1.setSim_cost(666);
		s1.setPhno(9900408969l);
		
		Sim s2=new Sim();
		s2.setSim_name("Airtel");
		s2.setSim_network_type("3g");
		s2.setSim_cost(888);
		s2.setPhno(9900445969l);
		
		Sim s3=new Sim();
		s3.setSim_name("BSNL");
		s3.setSim_network_type("3g");
		s3.setSim_cost(299);
		s3.setPhno(9900407869l);
		
		Sim s4=new Sim();
		s4.setSim_name("VI");
		s4.setSim_network_type("4g");
		s4.setSim_cost(777);
		s4.setPhno(9911408969l);
		
		List<Sim> list1=new ArrayList<Sim>();
		list1.add(s1);
		list1.add(s3);
		
		List<Sim> list2=new ArrayList<Sim>();
		list2.add(s2);
		list2.add(s4);
		
		m1.setSims(list1);
		m1.setSims(list1);
		m2.setSims(list2);
		m2.setSims(list2);
		
		entityTransaction.begin();
		entityManager.persist(m1);
		entityManager.persist(m2);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(s4);
		entityTransaction.commit();
		
		
	}
}
