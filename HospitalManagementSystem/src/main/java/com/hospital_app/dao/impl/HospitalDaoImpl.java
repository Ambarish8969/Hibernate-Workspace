package com.hospital_app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hospital_app.dao.HospitalDao;
import com.hospital_app.dto.Hospital;

public class HospitalDaoImpl implements HospitalDao {

	@Override
	public Hospital saveHospital(Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(et);
		et.commit();

		return hospital;
	}

	@Override
	public Hospital getHospitalId(int hid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Hospital hospital = em.find(Hospital.class, hid);

		return hospital;
	}

	@Override
	public boolean deleteHospitalId(int hid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Hospital hospital = em.find(Hospital.class, hid);

		if (hospital != null) {
			et.begin();
			em.remove(hospital);
			et.commit();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Hospital updateHospital(int hid, Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Hospital hospital2 = em.find(Hospital.class, hid);

		if (hospital2 != null) {
			hospital2.setName(hospital.getName());
			hospital2.setWebsite(hospital.getWebsite());
			et.begin();
			em.merge(hospital2);
			et.commit();
			return hospital2;
		} else {
			return null;
		}
	}

}
