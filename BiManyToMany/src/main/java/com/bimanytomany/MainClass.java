package com.bimanytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory emfEntityManagerFactory = Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager = emfEntityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student s1 = new Student();
		s1.setName("Ambika");
		s1.setAge(23);
		s1.setMarks(99);
		s1.setPhno(9876124635l);

		Student s2 = new Student();
		s2.setName("Ambarish");
		s2.setAge(23);
		s2.setMarks(89);
		s2.setPhno(9900408969l);

		Student s3 = new Student();
		s3.setName("Rakesh");
		s3.setAge(24);
		s3.setMarks(79);
		s3.setPhno(7894561230l);

		Course c1 = new Course();
		c1.setName("Python");
		c1.setFees(499);
		c1.setTrainer("Telusko");

		Course c2 = new Course();
		c2.setName("Java Fullstack");
		c2.setFees(599);
		c2.setTrainer("Harry");

		Course c3 = new Course();
		c3.setName("PHP");
		c3.setFees(399);
		c3.setTrainer("Rocky Bhai");

		List<Course> list_course1 = new ArrayList<Course>();
		list_course1.add(c1);
		list_course1.add(c3);

		List<Course> list_course2 = new ArrayList<Course>();
		list_course2.add(c1);
		list_course2.add(c2);

		List<Student> list_student1 = new ArrayList<Student>();
		list_student1.add(s1);
		list_student1.add(s3);

		List<Student> list_student2 = new ArrayList<Student>();
		list_student2.add(s1);
		list_student2.add(s2);

		s1.setCourse(list_course1);
		s2.setCourse(list_course2);
		s3.setCourse(list_course1);

		c1.setStudent(list_student1);
		c2.setStudent(list_student2);
		c3.setStudent(list_student1);

		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();

	}
}
