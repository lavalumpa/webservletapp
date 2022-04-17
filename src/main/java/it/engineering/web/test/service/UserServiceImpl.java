package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.UserRepository;

public class UserServiceImpl implements UserService {
	private static UserService instance;
	private UserRepository userRepository;
	
	private UserServiceImpl() {
		userRepository=UserRepository.getInstance();
	}
	
	
	@Override
	public String login(HttpServletRequest request, String username, String password) {
		String page ="";
		List<User> loggedUsers =(List<User> ) request.getServletContext().getAttribute("loggedUsers");
		User userSaved= userRepository.findByUsername(username);
		if (loggedUsers.contains(userSaved)) {
			request.setAttribute("message", "User logged in");
			page=Constants.PAGE_LOGIN;
			return page;
		}
		if (userSaved==null) {
			request.setAttribute("message", "User does not exist");
			page= Constants.PAGE_LOGIN;
			return page;
		}
		
		if (!userSaved.getPassword().equals(password)) {
			request.setAttribute("message", "User and password don't match");
			page= Constants.PAGE_LOGIN;
			return page;
		}
		loggedUsers.add(userSaved);
		request.getSession(true).setAttribute("user", userSaved);
		page = Constants.PAGE_HOME;
		return page;
	}


	

	public static UserService getInstance() {
		if (instance==null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}


	@Override
	public String logout(HttpServletRequest request) {
		User user = (User)request.getSession(true).getAttribute("user");
		request.getSession(true).removeAttribute("user");
		List<User> logged=(List<User>) request.getServletContext().getAttribute("loggedUsers");
		logged.remove(user);
		return Constants.PAGE_INDEX;
	}
	
	
	
}
