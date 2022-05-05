package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.web.test.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager em;
	


	@Override
	public void saveOrUpdate(User user) {
		em.merge(user);
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	@Override
	public User findByUsername(String username) {
		String query="SELECT u FROM User u WHERE  u.username=:username";
		List<User> users=em.createQuery(query,User.class).setParameter("username", username).getResultList();
		User user = users.size()==0? null : users.get(0);
		return user;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}
	

}
