package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.UserDaoImpl;
import com.hospital_app.dto.User;

public class UserService {

	public void saveUser(int userId, User user) {
		UserDaoImpl daoimp = new UserDaoImpl();
		User user1 = daoimp.saveUser(userId, user);
		if (user1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public User getUserId(int userId) {
		UserDaoImpl daoimp = new UserDaoImpl();
		User user1 = daoimp.getUserId(userId);
		if (user1 != null) {
			return user1;
		} else {
			return null;
		}
	}

	public void deleteUserId(int userId) {
		UserDaoImpl daoimp = new UserDaoImpl();
		boolean flag = daoimp.deleteUserId(userId);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public User updateUserId(int userId, User user) {
		UserDaoImpl daoimp = new UserDaoImpl();
		User address1 = daoimp.updateUserId(userId, user);
		if (address1 != null) {
			return address1;
		} else {
			return null;
		}
	}

	public void getAllUser() {
		UserDaoImpl daoimp = new UserDaoImpl();
		List<User> users = daoimp.getAllUser();
		for (User user : users) {
			System.out.println(user);
		}
	}

	public void getUserByRole(String role) {
		UserDaoImpl daoimp = new UserDaoImpl();
		List<User> users = daoimp.getUserByRole(role);
		for (User user : users) {
			System.out.println(user);
		}
	}
}
