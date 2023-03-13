package com.bionetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company company1=new Company();
		company1.setCompany_name("Mindtree");
		company1.setCompany_website("www.mindtree.com");
		company1.setCompany_location("Banglore");
		
		Company company2=new Company();
		company2.setCompany_name("Capgemini");
		company2.setCompany_website("www.capgemini.com");
		company2.setCompany_location("Mysore");
		
		Gst gst1=new Gst();
		gst1.setGst_no(4451987);
		gst1.setGst_state("Karnataka");
		gst1.setGst_country("India");
		
		Gst gst2=new Gst();
		gst2.setGst_no(1319876);
		gst2.setGst_state("Karnataka");
		gst2.setGst_country("India");
		
		company1.setGst(gst1);
		company2.setGst(gst2);
		
		gst1.setCompany(company1);
		gst2.setCompany(company2);
		
		entityTransaction.begin();
		entityManager.persist(company1);
		entityManager.persist(company2);
		entityManager.persist(gst1);
		entityManager.persist(gst2);
		entityTransaction.commit();
	}
}
