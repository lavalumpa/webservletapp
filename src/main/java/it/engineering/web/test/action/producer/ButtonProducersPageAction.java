package it.engineering.web.test.action.producer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.ProducerServiceImpl;

public class ButtonProducersPageAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		return ProducerServiceImpl.getInstance().producersButtonViewForm(request);
	}

}
