package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.BranchDao;
import com.hospital_app.dto.Branch;
import com.hospital_app.dto.Hospital;

public class BranchDaoImpl implements BranchDao {

	@Override
	public Branch saveBranch(int hid, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Hospital hospital = em.find(Hospital.class, hid);

		if (hospital != null) {
			et.begin();
			em.persist(branch);
			et.commit();
			return branch;
		} else {
			return null;
		}

	}

	@Override
	public Branch getBranch(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Branch branch = em.find(Branch.class, bid);

		return branch;
	}

	@Override
	public boolean deleteBranch(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Branch branch = em.find(Branch.class, bid);

		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Branch updateBranch(int bid, Branch branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Branch branch1 = em.find(Branch.class, bid);

		if (branch1 != null) {
			branch1.setName(branch.getName());
			branch1.setAddress(branch.getAddress());
			branch1.setEmail(branch.getEmail());
			branch1.setPhno(branch.getPhno());
			et.begin();
			em.merge(branch1);
			et.commit();
			return branch1;
		} else {
			return null;
		}
	}

	@Override
	public List<Branch> getAllBranches() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Branch s");

		List<Branch> branch = query.getResultList();

		return branch;
	}

}
