package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.ProducerRepository;

public class ProducerServiceImpl implements ProducerService{
	private static ProducerServiceImpl instance;
	private ProducerRepository producerRepository;
	private MestoRepository mestoRepository;
	 private ProducerServiceImpl() {
		 producerRepository = ProducerRepository.getInstance();
		 mestoRepository=MestoRepository.getInstance();
	 }
	

	public String viewAllProducers(HttpServletRequest request) {
		List<Producer> producers =producerRepository.findAll();
		request.setAttribute("producers", producers);
		return Constants.PAGE_ALL_PRODUCERS;
	}
	
	public void addProducer(HttpServletRequest request) {
		
	}
	public static ProducerServiceImpl getInstance() {
		if (instance==null) {
			instance = new ProducerServiceImpl();
		}
		return instance;
	}


	public String viewAddProducerPage(HttpServletRequest request) {
		List<Mesto> mesta = mestoRepository.findAll();
		request.setAttribute("mesta", mesta);
		return Constants.PAGE_ADD_PRODUCER;
	}
	
	
}
