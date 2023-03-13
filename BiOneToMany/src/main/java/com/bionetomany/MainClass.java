package com.bionetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person p1=new Person();
		p1.setName("Ambarish");
		p1.setPhno(9900408969l);
		
		Person p2=new Person();
		p2.setName("Ambika");
		p2.setPhno(4887946113l);
		
		Person p3=new Person();
		p3.setName("Nisha");
		p3.setPhno(1315454897l);
		
		Bank b1=new Bank();
		b1.setBname("SBI");
		b1.setLocation("Basavangudi");
		b1.setIfsc(103154);
		
		Bank b2=new Bank();
		b2.setBname("Canara Bank");
		b2.setLocation("Jayanagar");
		b2.setIfsc(798789);
		
		Bank b3=new Bank();
		b3.setBname("Axis Bank");
		b3.setLocation("JP Nagar");
		b3.setIfsc(4656561);
		
		Bank b4=new Bank();
		b4.setBname("HDFC Bank");
		b4.setLocation("Nagasandra");
		b4.setIfsc(1874384);
		
//		List<Person> persons1=new ArrayList<Person>();
//		persons1.add(p1);
//		persons1.add(p3);
//		List<Person> persons2=new ArrayList<Person>();
//		persons2.add(p2);
//		persons2.add(p3);
//		
		List<Bank> banks1=new ArrayList<Bank>();
		banks1.add(b1);
		banks1.add(b3);
		List<Bank> banks2=new ArrayList<Bank>();
		banks2.add(b2);
		banks2.add(b4);
		
		
		p1.setBanks(banks1);
		p2.setBanks(banks2);
		
		b1.setPerson(p1);
		b2.setPerson(p2);
		b3.setPerson(p2);
		b4.setPerson(p1);
		
		entityTransaction.begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(b1);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityManager.persist(b4);
//		entityManager.persist(p3);
		entityTransaction.commit();
		
	}
}
