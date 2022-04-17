package it.engineering.web.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.ProducerServiceImpl;
import it.engineering.web.test.service.UserService;
import it.engineering.web.test.service.UserServiceImpl;

public abstract class AbstractAction {

	private ProducerService producerService;
	private UserService userService;
	
	public AbstractAction() {
		producerService = ProducerServiceImpl.getInstance();
		userService = UserServiceImpl.getInstance();
	}
	
	protected ProducerService getProducerService() {
		return producerService;
	}
	
	
	protected UserService getUserService() {
		return userService;
	}
	public abstract String executeRequest(HttpServletRequest request, HttpServletResponse response) ;

}
