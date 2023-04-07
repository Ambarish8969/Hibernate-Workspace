package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.ObservationDao;
import com.hospital_app.dto.Encounter;
import com.hospital_app.dto.Observation;

public class ObservationDaoImpl implements ObservationDao {

	@Override
	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Encounter encounter = em.find(Encounter.class, eid);

		if (encounter != null) {
			et.begin();
			em.persist(observation);
			et.commit();
			return observation;
		} else {
			return null;
		}
	}

	@Override
	public Observation getObservationId(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Observation observation = em.find(Observation.class, oid);

		return observation;
	}

	@Override
	public boolean deleteObservationId(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Observation observation = em.find(Observation.class, oid);

		if (observation != null) {
			et.begin();
			em.remove(observation);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Observation updateObservationId(int oid, Observation observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Observation observation1 = em.find(Observation.class, oid);

		if (observation1 != null) {
			observation1.setDoctorName(observation.getDoctorName());
			observation1.setReason_observtion(observation.getReason_observtion());
			observation1.setEncounters(observation.getEncounters());
			et.begin();
			em.merge(observation1);
			et.commit();
			return observation1;
		} else {
			return null;
		}
	}

	@Override
	public List<Observation> getAllObservation() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Observation s");

		List<Observation> observation = query.getResultList();

		return observation;
	}

	@Override
	public List<Observation> getObservationByDoctorName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Observation s where dname=?1");
		query.setParameter(1, name);

		List<Observation> observation = query.getResultList();

		return observation;
	}

}
