package com.hospital_app.dao;

import java.util.List;

import com.hospital_app.dto.Items;

public interface ItemDao {
	public Items saveItem(int itemId,Items item);
	
	public Items getItemId(int itemId);
	
	public boolean deleteItemId(int itemId);
	
	public Items updateItemId(int itemId,Items item);
	
	public List<Items> getAllItems();
}
