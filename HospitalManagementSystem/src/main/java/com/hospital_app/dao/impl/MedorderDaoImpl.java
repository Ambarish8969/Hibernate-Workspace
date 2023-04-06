package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.MedorderDao;
import com.hospital_app.dto.Medorder;

public class MedorderDaoImpl implements MedorderDao {

	@Override
	public Medorder saveMedorder(int mid, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Medorder medorder1 = em.find(Medorder.class, mid);

		if (medorder != null) {
			et.begin();
			em.persist(medorder1);
			et.commit();
			return medorder1;
		} else {
			return null;
		}
	}

	@Override
	public Medorder getMedorder(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Medorder medorder1 = em.find(Medorder.class, mid);

		return medorder1;
	}

	@Override
	public boolean deleteMedorder(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Medorder medorder1 = em.find(Medorder.class, mid);

		if (medorder1 != null) {
			et.begin();
			em.remove(medorder1);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Medorder updateMedorder(int mid, Medorder medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Medorder medorder1 = em.find(Medorder.class, mid);

		if (medorder1 != null) {
			medorder1.setDname(medorder.getDname());
			medorder1.setOrderdate(medorder.getOrderdate());
			medorder1.setTotal(medorder.getTotal());
			medorder1.setItems(medorder.getItems());
			medorder1.setEncounter(medorder.getEncounter());
			et.begin();
			em.merge(medorder1);
			et.commit();
			return medorder1;
		} else {
			return null;
		}
	}

	@Override
	public List<Medorder> getAllMedorder() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Medorder s");

		List<Medorder> medorder1 = query.getResultList();

		return medorder1;
	}

	@Override
	public List<Medorder> getMedorderByDoctorname(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Medorder s where dname=?1");
		query.setParameter(1, name);

		List<Medorder> medorder1 = query.getResultList();

		return medorder1;
	}

}
