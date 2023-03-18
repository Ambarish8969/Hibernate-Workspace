package com.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Punith punith=new Punith();
		punith.setName("PunithRajkumar");
		punith.setBirthDate(new Date());
		
		FileInputStream fileInputStream=new FileInputStream("src/main/java/punith2.jpg");
		byte[] data= new byte[fileInputStream.available()];
		fileInputStream.read(data);
		
		entityTransaction.begin();
		entityManager.persist(punith);
		entityTransaction.commit();
	}
}
