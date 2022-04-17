package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.User;
import it.engineering.web.test.persistance.MyEntityManagerFactory;

public class UserRepositoryImpl implements UserRepository {
	private static UserRepository instance;
	
	
	@Override
	public void saveOrUpdate(User user, EntityManager em) {
		em.merge(user);
	}

	@Override
	public User findById(Long id, EntityManager em) {
		return em.find(User.class, id);
	}
	
	@Override
	public User findByUsername(String username, EntityManager em) {
		String query="SELECT u FROM user u WHERE u.username=:user1";
		List<User> users=em.createQuery(query,User.class).setParameter("user1", username).getResultList();
		User user = users.size()==0? null : users.get(0);
		return user;
	}

	@Override
	public void delete(Long id, EntityManager em) {
		User user = em.find(User.class, id);
		em.remove(user);
	}
	
	public static UserRepository getInstance() {
		if (instance==null) {
			instance = new UserRepositoryImpl();
		}
		return instance;
	}
}
