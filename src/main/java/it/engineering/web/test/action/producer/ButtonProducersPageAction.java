package it.engineering.web.test.action.producer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.constants.Constants;

public class ButtonProducersPageAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {	
		if (request.getSession(true).getAttribute("user")==null) {
			return Constants.PAGE_LOGIN;
		}
		return getProducerService().producersButtonViewForm(request);
	}

}
