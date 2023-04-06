package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.EncounterDao;
import com.hospital_app.dto.Branch;
import com.hospital_app.dto.Encounter;

public class EncounterDaoImpl implements EncounterDao {

	@Override
	public Encounter saveEncounter(int bid, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Branch branch = em.find(Branch.class, bid);

		if (branch != null) {
			et.begin();
			em.persist(encounter);
			et.commit();
			return encounter;
		} else {
			return null;
		}
	}

	@Override
	public Encounter getEncounter(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Encounter encounter = em.find(Encounter.class, eid);

		return encounter;
	}

	@Override
	public boolean deleteEncounter(int eid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Encounter encounter = em.find(Encounter.class, eid);

		if (encounter != null) {
			et.begin();
			em.remove(encounter);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Encounter updateEncounter(int eid, Encounter encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Encounter encounter1 = em.find(Encounter.class, eid);

		if (encounter1 != null) {
			encounter1.setDateOfJoin(encounter.getDateOfJoin());
			encounter1.setDateOfDischarge(encounter.getDateOfDischarge());

			et.begin();
			em.merge(encounter1);
			et.commit();
			return encounter1;
		} else {
			return null;
		}
	}

	@Override
	public List<Encounter> getAllEncounter() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Encounter s");

		List<Encounter> encounter = query.getResultList();

		return encounter;
	}

}
