package it.engineering.web.test.action.producer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.service.ProducerService;
import it.engineering.web.test.service.UserService;

@Component
public class PostAddProducerAction extends AbstractAction{
	
	
	@Autowired
	public PostAddProducerAction(ProducerService producerService, UserService userService) {
		super(producerService, userService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(true).getAttribute("user")== null) {
			return Constants.PAGE_LOGIN;
		}
		System.out.println("mesta: \n" +(List<Mesto>)request.getAttribute("mesta"));
		return getProducerService().addProducer(request);

	}

}
