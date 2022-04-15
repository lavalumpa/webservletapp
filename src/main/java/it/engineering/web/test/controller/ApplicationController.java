package it.engineering.web.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.actionfactory.ActionFactory;

public class ApplicationController {

	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		
		AbstractAction action = ActionFactory.createAction(method, path);
		return action.executeRequest(request, response);
	}
 
}
