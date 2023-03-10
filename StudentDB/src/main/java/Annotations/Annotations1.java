package Annotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Annotations1 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student2 s1=new Student2();
		s1.setName("Nitish");
		s1.setAge(52);
		s1.setPhno(9156444465l);
		
		Student2 s4=new Student2();
		s4.setName("ambarish");
		s4.setAge(23);
		s4.setPhno(654432898655l); // we can fix length for int,long.
		
		entityTransaction.begin();
		entityManager.persist(s4);
		entityTransaction.commit();
	}
}
