package it.engineering.web.test.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.UserRepository;
import it.engineering.web.test.service.UserServiceImpl;

public class LoginPostAction extends AbstractAction {
	private UserServiceImpl userService;
	
	public LoginPostAction() {
		super();
		userService= UserServiceImpl.getInstance();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		return userService.login(request, username, password);
	}



}
