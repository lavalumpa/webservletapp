package it.engineering.web.test.repository;

import it.engineering.web.test.domain.User;

public interface UserRepository {

	void saveOrUpdate(User user);

	User findById(Long id);

	User findByUsername(String username);

	void delete(Long id);

}