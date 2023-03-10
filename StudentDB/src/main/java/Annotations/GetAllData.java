package Annotations;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllData {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
//		Query query=entityManager.createQuery("select s from Student2 s");
		
		Query query=entityManager.createQuery("select s from Student2 s where s.age<?1");
		query.setParameter(1, 50);
		
		List<Student2> students=query.getResultList();
		
		for (Student2 student2 : students) {
			System.out.println("Student Id : "+student2.getId());
			System.out.println("Student Name : "+student2.getName());
			System.out.println("Student Age : "+student2.getAge());
			System.out.println("Student Phno : "+student2.getPhno());
			System.out.println("----------------------------------------");
		}
	}
}
