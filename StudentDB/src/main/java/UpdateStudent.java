import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ambika");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
				
		Student student=entityManager.find(Student.class, 101);
		
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getMarks());
		
		System.out.println("---------------------------");
		
		student.setAge(115);
		student.setName("Nora");
		
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
	}
}
