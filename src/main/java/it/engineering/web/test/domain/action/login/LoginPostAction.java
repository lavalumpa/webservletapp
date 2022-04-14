package it.engineering.web.test.domain.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.domain.action.AbstractAction;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.UserRepository;

public class LoginPostAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		UserRepository userRepository= new UserRepository();
		String username = request.getParameter("username");
		User user = userRepository.findByUsername(username);
		List<User> loggedUsers =(List<User> ) request.getServletContext().getAttribute("loggedUsers");
		if (loggedUsers.contains(user)) {
			request.setAttribute("message", "User logged in");
			return Constants.PAGE_LOGIN;
		}
		if (user==null) {
			request.setAttribute("message", "User does not exist");
			return Constants.PAGE_LOGIN;
		}
		String password = request.getParameter("password");
		if (!user.getPassword().equals(password)) {
			request.setAttribute("message", "User and password don't match");
			return Constants.PAGE_LOGIN;
		}
		ProducerRepository prodRepository = new ProducerRepository();
		List<Producer> producers = prodRepository.findAll();
		System.out.println(producers);
		request.setAttribute("producers", (List<Producer>) producers);
		request.setAttribute("user", user);
		loggedUsers.add(user);
		return Constants.PAGE_HOME;
	}

}
