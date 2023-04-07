package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.ItemDaoImpl;
import com.hospital_app.dto.Items;

public class ItemService {

	public void saveItem(int itemId, Items item) {
		ItemDaoImpl daoimp = new ItemDaoImpl();
		Items item1 = daoimp.saveItem(itemId, item);
		if (item1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Items getItemId(int itemId) {
		ItemDaoImpl daoimp = new ItemDaoImpl();
		Items item1 = daoimp.getItemId(itemId);
		if (item1 != null) {
			return item1;
		} else {
			return null;
		}
	}

	public void deleteItemId(int itemId) {
		ItemDaoImpl daoimp = new ItemDaoImpl();
		boolean flag = daoimp.deleteItemId(itemId);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Items updateItemId(int itemId, Items item) {
		ItemDaoImpl daoimp = new ItemDaoImpl();
		Items item1 = daoimp.updateItemId(itemId, item);
		if (item1 != null) {
			return item1;
		} else {
			return null;
		}
	}

	public void getAllItems() {
		ItemDaoImpl daoimp = new ItemDaoImpl();
		List<Items> items = daoimp.getAllItems();
		for (Items item : items) {
			System.out.println(item);
		}
	}
}
