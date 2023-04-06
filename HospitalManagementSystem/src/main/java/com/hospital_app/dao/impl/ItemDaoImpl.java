package com.hospital_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital_app.dao.ItemDao;
import com.hospital_app.dto.Items;

public class ItemDaoImpl implements ItemDao {

	@Override
	public Items saveItem(int itemId, Items item) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Items item1 = em.find(Items.class, itemId);

		if (item != null) {
			et.begin();
			em.persist(item1);
			et.commit();
			return item1;
		} else {
			return null;
		}
	}

	@Override
	public Items getItemId(int itemId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Items items = em.find(Items.class, itemId);

		return items;
	}

	@Override
	public boolean deleteItemId(int itemId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Items items = em.find(Items.class, itemId);

		if (items != null) {
			et.begin();
			em.remove(items);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Items updateItemId(int itemId, Items item) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Items items = em.find(Items.class, itemId);

		if (items != null) {
			items.setCost(item.getCost());
			items.setName(item.getName());
			items.setQuantity(item.getQuantity());
			et.begin();
			em.merge(items);
			et.commit();
			return items;
		} else {
			return null;
		}
	}

	@Override
	public List<Items> getAllItems() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ambika");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select s from Items s");

		List<Items> items = query.getResultList();

		return items;
	}

}
