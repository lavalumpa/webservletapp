package it.engineering.web.test.domain.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.User;
import it.engineering.web.test.domain.action.AbstractAction;
import it.engineering.web.test.repository.UserRepository;

public class LoginGetAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return Constants.PAGE_LOGIN;
	}

}
