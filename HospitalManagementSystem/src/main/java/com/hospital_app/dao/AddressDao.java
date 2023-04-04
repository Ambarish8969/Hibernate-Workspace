package com.hospital_app.dao;

import java.util.List;

import com.hospital_app.dto.Address;

public interface AddressDao {
	public Address saveAddress(int bid,Address address);

	public Address getAddress(int id);

	public boolean deleteAddress(int id);

	public Address updateAddress(int id,Address address);
	
	public List<Address> getAllAddresses();
}
