package it.engineering.web.test.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.UserService;

@Component
public class LoginPostAction extends AbstractAction {
	
	@Autowired
	public LoginPostAction(ProducerService producerService, UserService userService) {
		super(producerService, userService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		return getUserService().login(request, username, password);
	}



}
