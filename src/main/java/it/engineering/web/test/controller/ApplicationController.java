package it.engineering.web.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.actionfactory.ActionFactory;

@Component
public class ApplicationController {
	@Autowired
	private ActionFactory actionFactory;

	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		
		AbstractAction action = actionFactory.createAction(method, path);
		return action.executeRequest(request, response);
	}
 
}
