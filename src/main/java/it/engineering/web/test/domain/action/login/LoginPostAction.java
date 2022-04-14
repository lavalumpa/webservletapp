package it.engineering.web.test.domain.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.domain.action.AbstractAction;
import it.engineering.web.test.repository.UserRepository;

public class LoginPostAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		UserRepository userRepository= new UserRepository();
		String username = request.getParameter("username");
		User user = userRepository.findByUsername(username);
		if (user==null) {
			request.setAttribute("message", "User does not exist");
			return Constants.PAGE_LOGIN;
		}
		String password = request.getParameter("password");
		if (!user.getPassword().equals(password)) {
			request.setAttribute("message", "User and password don't match");
			return Constants.PAGE_LOGIN;
		}
		request.setAttribute("user", user);
		return Constants.PAGE_HOME;
	}

}
