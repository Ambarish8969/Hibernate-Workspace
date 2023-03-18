package lastcrud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Institute institute1=new Institute();
		institute1.setName("Jspiders");
		institute1.setWebsite("www.jspiders.com");
		institute1.setNoOfTrainers(32);
		
		Institute institute2=new Institute();
		institute2.setName("Qspiders");
		institute2.setWebsite("www.Qspiders.com");
		institute2.setNoOfTrainers(42);
		
		Branch branch1=new Branch();
		branch1.setLocation("Basavanagudi");
		branch1.setPhno(4878113246465l);
		branch1.setCourseName("JavaFullStack");
		
		Branch branch2=new Branch();
		branch2.setLocation("Rajajinagar");
		branch2.setPhno(4878142365l);
		branch2.setCourseName("PythonFullStack");
		
		Branch branch3=new Branch();
		branch3.setLocation("Marathhalli");
		branch3.setPhno(9918113246465l);
		branch3.setCourseName("PHPFullStack");
		
		Branch branch4=new Branch();
		branch4.setLocation("Hebbal");
		branch4.setPhno(423100465l);
		branch4.setCourseName("WebDevelopment");
		
		List<Branch> branchList1=new ArrayList<Branch>();
		branchList1.add(branch1);
		branchList1.add(branch4);
		
		List<Branch> branchList2=new ArrayList<Branch>();
		branchList2.add(branch3);
		branchList2.add(branch2);
		
		institute1.setBranches(branchList1);
		institute2.setBranches(branchList2);
		
		branch1.setInstitute(institute1);
		branch2.setInstitute(institute2);
		branch3.setInstitute(institute1);
		branch4.setInstitute(institute2);
		
		entityTransaction.begin();
		entityManager.persist(institute1);
		entityManager.persist(institute2);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityManager.persist(branch4);
		entityTransaction.commit();
		
	}
}
