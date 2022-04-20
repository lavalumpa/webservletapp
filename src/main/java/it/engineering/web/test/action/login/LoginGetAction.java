package it.engineering.web.test.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.repository.UserRepositoryImpl;
import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.UserService;

@Component
public class LoginGetAction extends AbstractAction {

	@Autowired
	public LoginGetAction(ProducerService producerService, UserService userService) {
		super(producerService, userService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return Constants.PAGE_LOGIN;
	}

}
