package com.fetch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile1 mobile = new Mobile1();
		mobile.setBrand("Iphone");
		mobile.setColor("black");
		mobile.setRam("8gb");
		mobile.setCost(10000.0);

		Mobile1 mobile1 = new Mobile1();
		mobile1.setBrand("Samsung");
		mobile1.setColor("blue");
		mobile1.setRam("12gb");
		mobile1.setCost(14000.0);

		Sim1 sim = new Sim1();
		sim.setProvider("jio");
		sim.setType("5g");
		sim.setPhno(12345678l);
		sim.setCost(50.0);

		Sim1 sim1 = new Sim1();
		sim1.setProvider("airtel");
		sim1.setType("5g");
		sim1.setPhno(88845678l);
		sim1.setCost(50.0);

		Sim1 sim2 = new Sim1();
		sim2.setProvider("bsnl");
		sim2.setType("4g");
		sim2.setPhno(77745678l);
		sim2.setCost(50.0);

		Sim1 sim3 = new Sim1();
		sim3.setProvider("vi");
		sim3.setType("5g");
		sim3.setPhno(9999678l);
		sim3.setCost(50.0);

		List<Sim1> list = new ArrayList<Sim1>();
		list.add(sim);
		list.add(sim1);

		List<Sim1> list1 = new ArrayList<Sim1>();
		list1.add(sim2);
		list1.add(sim3);

		mobile.setSims(list);
		mobile1.setSims(list1);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(mobile1);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityTransaction.commit();

//		Mobile mobile5 = entityManager.find(Mobile.class, 1);
//		System.out.println(mobile5.getId());
//
//		Sim sim5 = entityManager.find(Sim.class, 1);
//		System.out.println(sim5.getProvider());
	}
}
