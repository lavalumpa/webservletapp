package it.engineering.web.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.ProducerServiceImpl;

public abstract class AbstractAction {

	private ProducerService producerService;
	
	public AbstractAction() {
		producerService = ProducerServiceImpl.getInstance();
	}
	
	protected ProducerService getProducerService() {
		return producerService;
	}
	
	public abstract String executeRequest(HttpServletRequest request, HttpServletResponse response) ;

}
