package it.engineering.web.test.domain.testing;

import javax.persistence.EntityManager;

import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.UserRepository;
import it.engineering.web.test.repository.UserRepositoryImpl;

public class UserRepositoryTest {
	public static void main(String[] args) {
//		User user1= new User("user1", "user1");
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		UserRepository userRepository= new UserRepositoryImpl(em);
		em.getTransaction().begin();
//		userRepository.saveOrUpdate(user1);
		System.out.println(userRepository.findByUsername("user1"));
		em.getTransaction().commit();
	}
}
