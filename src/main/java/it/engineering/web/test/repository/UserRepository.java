package it.engineering.web.test.repository;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.User;

public interface UserRepository {
	
	void saveOrUpdate(User user, EntityManager em);

	User findById(Long id, EntityManager em);

	User findByUsername(String username, EntityManager em);

	void delete(Long id, EntityManager em);

}