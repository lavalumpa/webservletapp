package it.engineering.web.test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.UserService;

@Component
public class HomeGetAction extends AbstractAction {

	@Autowired
	public HomeGetAction(ProducerService producerService, UserService userService) {
		super(producerService, userService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(true).getAttribute("user")==null) {
			return Constants.VIEW_LOGIN;
		}
		return Constants.VIEW_HOME;
	}

}
