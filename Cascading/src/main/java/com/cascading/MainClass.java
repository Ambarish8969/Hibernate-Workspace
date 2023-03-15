package com.cascading;

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

		Hospital hospital1 = new Hospital();
		hospital1.setName("apollo");
		hospital1.setWebsite("www.apollo.com");
		hospital1.setNo_doctors(10);

		Hospital hospital2 = new Hospital();
		hospital2.setName("narayan");
		hospital2.setWebsite("www.narayan.com");
		hospital2.setNo_doctors(15);

		Hospital hospital3 = new Hospital();
		hospital3.setName("kle");
		hospital3.setWebsite("www.kle.com");
		hospital3.setNo_doctors(20);

		Branch branch1 = new Branch();
		branch1.setName("Basavangudi");
		branch1.setLocation("near jain temple");
		branch1.setPhno(751646519595l);

		Branch branch2 = new Branch();
		branch2.setName("Jayanagar");
		branch2.setLocation("near ganesh temple");
		branch2.setPhno(751646710203l);

		Branch branch3 = new Branch();
		branch3.setName("JP Nagar");
		branch3.setLocation("near Hanuman temple");
		branch3.setPhno(478646519595l);

		List<Branch> branchList1 = new ArrayList<Branch>();
		branchList1.add(branch1);
		branchList1.add(branch3);

		List<Branch> branchList2 = new ArrayList<Branch>();
		branchList2.add(branch2);
		branchList2.add(branch3);

		hospital1.setBranches(branchList2);
		hospital2.setBranches(branchList1);
		hospital3.setBranches(branchList2);

		branch1.setHospital(hospital1);
		branch2.setHospital(hospital2);
		branch3.setHospital(hospital3);

		entityTransaction.begin();
		entityManager.persist(hospital1);
		entityManager.persist(hospital2);
		entityManager.persist(hospital3);
// Here we need not to persist branches , because it will automatically saves in the database by cascading.
//		entityManager.persist(branch1);
//		entityManager.persist(branch2);
//		entityManager.persist(branch3);
		entityTransaction.commit();
	}
}
