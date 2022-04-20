package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.User;

public class UserRepositoryImpl implements UserRepository {
	private EntityManager em;
	
	
	public UserRepositoryImpl(EntityManager em) {
		this.em = em;
	}

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
		String query="SELECT u FROM user u WHERE u.username=:user1";
		List<User> users=em.createQuery(query,User.class).setParameter("user1", username).getResultList();
		User user = users.size()==0? null : users.get(0);
		return user;
	}

	@Override
	public void delete(Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
	}
	

}
