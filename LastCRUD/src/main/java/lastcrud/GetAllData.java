package lastcrud;

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
		
		Query query=entityManager.createQuery("select i from Institute i");
		
		List<Institute> institutes=query.getResultList();
		
		for (Institute institute : institutes) {
			System.out.println(institute.getName());
			System.out.println(institute.getId());
			System.out.println(institute.getWebsite());
			System.out.println(institute.getNoOfTrainers());
			System.out.println("--------------------------------");
			
			List<Branch> branchs=institute.getBranches();
			
			for(Branch branch:branchs) {
				System.out.println(branch.getLocation());
				System.out.println(branch.getPhno());
				System.out.println(branch.getCourseName());
				System.out.println("----------------------------");
			}
		}
	}
}
