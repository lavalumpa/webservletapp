package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.ProducerRepository;

public class ProducerServiceImpl implements ProducerService{
	private static ProducerServiceImpl instance;
	private ProducerRepository producerRepository;
	 private ProducerServiceImpl() {
		 producerRepository = ProducerRepository.getInstance();
	 }
	

	public String viewAllProducers(HttpServletRequest request) {
		List<Producer> producers =producerRepository.findAll();
		request.setAttribute("producers", producers);
		return Constants.PAGE_ALL_PRODUCERS;
	}
	public static ProducerServiceImpl getInstance() {
		if (instance==null) {
			instance = new ProducerServiceImpl();
		}
		return instance;
	}
}
