package it.engineering.web.test.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;

public class LoginPostAction extends AbstractAction {
	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		return getUserService().login(request, username, password);
	}



}
