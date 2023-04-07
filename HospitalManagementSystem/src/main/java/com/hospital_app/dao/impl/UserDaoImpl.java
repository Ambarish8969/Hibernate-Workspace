package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.UserDao;
import com.hospital_app.dto.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User saveUser(int userId, User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user1 = em.find(User.class, userId);

		if (user != null) {
			et.begin();
			em.persist(user1);
			et.commit();
			return user1;
		} else {
			return null;
		}
	}

	@Override
	public User getUserId(int userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = em.find(User.class, userId);

		return user;
	}

	@Override
	public boolean deleteUserId(int userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = em.find(User.class, userId);

		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User updateUserId(int userId, User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user1 = em.find(User.class, userId);

		if (user1 != null) {
			user1.setName(user.getName());
			user1.setPhno(user.getPhno());
			user1.setPassword(user.getPassword());
			user1.setRole(user.getRole());
			user1.setEmail(user.getEmail());
			et.begin();
			em.merge(user1);
			et.commit();
			return user1;
		} else {
			return null;
		}
	}

	@Override
	public List<User> getAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from User s");

		List<User> user = query.getResultList();

		return user;
	}

	@Override
	public List<User> getUserByRole(String role) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from User s where role=?1");
		query.setParameter(1, role);

		List<User> user = query.getResultList();

		return user;
	}
	
}
