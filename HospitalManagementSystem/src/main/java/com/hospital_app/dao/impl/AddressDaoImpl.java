package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.AddressDao;
import com.hospital_app.dto.Address;
import com.hospital_app.dto.Branch;

public class AddressDaoImpl implements AddressDao {

	@Override
	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Branch branch = em.find(Branch.class, bid);

		if (branch != null) {
			et.begin();
			em.persist(address);
			et.commit();
			return address;
		} else {
			return null;
		}
	}

	@Override
	public Address getAddress(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Address address = em.find(Address.class, id);

		return address;
	}

	@Override
	public boolean deleteAddress(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Address address = em.find(Address.class, id);

		if (address != null) {
			et.begin();
			em.remove(address);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Address updateAddress(int id, Address address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Address address1 = em.find(Address.class, id);

		if (address1 != null) {
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			address1.setBranch(address.getBranch());
			address1.setCountry(address.getCountry());
			et.begin();
			em.merge(address1);
			et.commit();
			return address1;
		} else {
			return null;
		}
	}

	@Override
	public List<Address> getAllAddresses() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Address s");

		List<Address> address = query.getResultList();

		return address;
	}

}
