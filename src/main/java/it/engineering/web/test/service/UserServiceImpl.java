package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	

	

	@Override
	public String login(HttpServletRequest request, String username, String password) {
		String page = "";
		List<User> loggedUsers = (List<User>) request.getServletContext().getAttribute("loggedUsers");
		User userSaved = userRepository.findByUsername(username);
		if (loggedUsers.contains(userSaved)) {
			request.setAttribute("message", "User logged in");
			page = Constants.VIEW_LOGIN;
			return page;
		}
		if (userSaved == null) {
			request.setAttribute("message", "User does not exist");
			page = Constants.VIEW_LOGIN;
			return page;
		}

		if (!userSaved.getPassword().equals(password)) {
			request.setAttribute("message", "User and password don't match");
			page = Constants.VIEW_LOGIN;
			return page;
		}
		loggedUsers.add(userSaved);
		request.getSession(true).setAttribute("user", userSaved);
		page = Constants.VIEW_HOME;
		
		return page;
	}

	

	@Override
	public String logout(HttpServletRequest request) {
		User user = (User) request.getSession(true).getAttribute("user");
		request.getSession(true).removeAttribute("user");
		List<User> logged = (List<User>) request.getServletContext().getAttribute("loggedUsers");
		logged.remove(user);
		
		return Constants.VIEW_INDEX;
	}

}
