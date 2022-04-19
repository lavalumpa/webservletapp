package it.engineering.web.test.service;

import javax.servlet.http.HttpServletRequest;

public interface ProducerService {

	String viewAllProducers(HttpServletRequest request);

	String addProducer(HttpServletRequest request);

	String editConfirmPressed(HttpServletRequest request);

	String deleteConfirmPressed(HttpServletRequest request);

	String viewAddProducerPage(HttpServletRequest request);

	String producersButtonViewForm(HttpServletRequest request);

	String editProducer(HttpServletRequest request);


	

}
