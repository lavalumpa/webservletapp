package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.User;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class UserRepository {
	private static UserRepository instance;
	private UserRepository() {
	}
	public void saveOrUpdate(User user) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		System.out.println(user);
		em.getTransaction().commit();
	}

	public User findById(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		return em.find(User.class, id);
	}
	
	public User findByUsername(String username) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		String query="SELECT u FROM user u WHERE u.username=:user1";
		List<User> users=em.createQuery(query,User.class).setParameter("user1", username).getResultList();
		User user = users.size()==0? null : users.get(0);
		return user;
	}

	public void delete(Long id) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		User user = em.find(User.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
	
	public static UserRepository getInstance() {
		if (instance==null) {
			instance = new UserRepository();
		}
		return instance;
	}
}
