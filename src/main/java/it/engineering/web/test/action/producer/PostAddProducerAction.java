package it.engineering.web.test.action.producer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;

public class PostAddProducerAction extends AbstractAction{
	
	
	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		 getProducerService().addProducer(request);
		 return getProducerService().viewAllProducers(request);
	}

}
