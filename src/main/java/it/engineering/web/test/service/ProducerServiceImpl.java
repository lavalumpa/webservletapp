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
		Long pib = Long.parseLong(request.getParameter("pib"));
		Long matBroj = Long.parseLong(request.getParameter("maticniBroj"));
		String adresa = request.getParameter("adresa");
		Long mestoId = Long.parseLong(request.getParameter("idMesta"));
		Mesto mesto=mestoRepository.findById(mestoId);
		Producer producer= new Producer(pib, matBroj, adresa, mesto);
		producerRepository.saveOrUpdate(producer);
		
	}


	public String viewAddProducerPage(HttpServletRequest request) {
		List<Mesto> mesta = mestoRepository.findAll();
		request.setAttribute("mesta", mesta);
		return Constants.PAGE_ADD_PRODUCER;
	}


	public String producersButtonViewForm(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page ="";
		if (button.equalsIgnoreCase("delete")) {
			page = Constants.PAGE_DELETE_PRODUCER;
		}
		if (button.equalsIgnoreCase("edit")) {
			request.setAttribute("mesta", mestoRepository.findAll());
			page = Constants.PAGE_EDIT_PRODUCER;
		}
		System.out.println("page: " + page);
		System.out.println("id: " + request.getParameterValues("id"));
		Long id = Long.parseLong(request.getParameter("id"));
		Producer producer =producerRepository.findById(id);
		request.setAttribute("producer", producer);
		return page;
	}
	
	public static ProducerServiceImpl getInstance() {
		if (instance==null) {
			instance = new ProducerServiceImpl();
		}
		return instance;
	}
	
}
