package it.engineering.web.test.domain.testing;

import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.UserRepository;

public class UserRepositoryTest {
	public static void main(String[] args) {
//		User user1= new User("user1", "user1");
		UserRepository userRepository=UserRepository.getInstance();
//		userRepository.saveOrUpdate(user1);
		System.out.println(userRepository.findByUsername("user1"));
	}
}
