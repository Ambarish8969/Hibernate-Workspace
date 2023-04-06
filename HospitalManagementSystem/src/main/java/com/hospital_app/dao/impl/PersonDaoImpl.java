package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.PersonDao;
import com.hospital_app.dto.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public Person savePerson(int personId, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person person1 = em.find(Person.class, personId);

		if (person != null) {
			et.begin();
			em.persist(person1);
			et.commit();
			return person1;
		} else {
			return null;
		}
	}

	@Override
	public Person getPersonId(int personId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person person = em.find(Person.class, personId);

		return person;
	}

	@Override
	public boolean deletePersonId(int personId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person person = em.find(Person.class, personId);

		if (person != null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Person updatePersonId(int personId, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person person1 = em.find(Person.class, personId);

		if (person1 != null) {
			person1.setName(person.getName());
			person1.setAge(person.getAge());
			person1.setDob(person.getDob());
			person1.setAddress(person.getAddress());
			person1.setGender(person.getGender());
			person1.setPhno(person.getPhno());
			et.begin();
			em.merge(person1);
			et.commit();
			return person1;
		} else {
			return null;
		}
	}

	@Override
	public List<Person> getAllPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Person s");

		List<Person> person = query.getResultList();

		return person;
	}

	@Override
	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Person s where gender=?1");
		query.setParameter(1, gender);

		List<Person> person = query.getResultList();

		return person;
	}

	@Override
	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Person s where age=?1");
		query.setParameter(1, age);

		List<Person> person = query.getResultList();

		return person;
	}

	@Override
	public List<Person> gerPersonByPhone(long phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Person s where phone=?1");
		query.setParameter(1, phone);

		List<Person> person = query.getResultList();

		return person;
	}

}
