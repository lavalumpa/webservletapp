package it.engineering.web.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.constants.Constants;

public class HomeGetAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(true).getAttribute("user")==null) {
			return Constants.PAGE_LOGIN;
		}
		return Constants.PAGE_HOME;
	}

}
