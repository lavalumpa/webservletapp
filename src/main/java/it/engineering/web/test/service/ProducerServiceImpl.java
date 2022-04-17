package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

public class ProducerServiceImpl implements ProducerService{
	private static ProducerService instance;
	private ProducerRepository producerRepository;
	private MestoRepository mestoRepository;
	 private ProducerServiceImpl() {
		 producerRepository = ProducerRepositoryImpl.getInstance();
		 mestoRepository=MestoRepositoryImpl.getInstance();
	 }
	
	@Override
	public String viewAllProducers(HttpServletRequest request) {
		List<Producer> producers =producerRepository.findAll();
		request.setAttribute("producers", producers);
		return Constants.PAGE_ALL_PRODUCERS;
	}
	@Override
	public void addProducer(HttpServletRequest request) {
		Producer producer = readProducer(request);
		producerRepository.saveOrUpdate(producer);
		
	}



	@Override
	public String viewAddProducerPage(HttpServletRequest request) {
		List<Mesto> mesta = mestoRepository.findAll();
		request.setAttribute("mesta", mesta);
		return Constants.PAGE_ADD_PRODUCER;
	}

	@Override
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
		Long id = Long.parseLong(request.getParameter("id"));
		Producer producer =producerRepository.findById(id);
		request.setAttribute("producer", producer);
		return page;
	}
	
	public static ProducerService getInstance() {
		if (instance==null) {
			instance = new ProducerServiceImpl();
		}
		return instance;
	}

	@Override
	public String editProducer(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page="";
		if (button.equalsIgnoreCase("back")) {
			page=Constants.PAGE_ALL_PRODUCERS;
			request.setAttribute("producers", producerRepository.findAll());
		}
		if (button.equalsIgnoreCase("save changes")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Producer producerOld = producerRepository.findById(id);
			Producer newProducer = readProducer(request);
			request.setAttribute("oldProducer", producerOld);
			request.setAttribute("newProducer", newProducer);
			page=Constants.PAGE_EDIT_PRODUCER_CONFIRM;
		}
		return page;
	}
	

	@Override
	public String editConfirmPressed(HttpServletRequest request) {
		String button =request.getParameter("button");
		String page = Constants.PAGE_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm edit")) {
			Producer producer = readProducer(request);
			producerRepository.saveOrUpdate(producer);
		}
		request.setAttribute("producers", producerRepository.findAll());
		return page;
	}
	
	@Override
	public String deleteConfirmPressed(HttpServletRequest request) {
		String button =request.getParameter("button");
		String page = Constants.PAGE_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm delete")) {
			Long id = Long.parseLong(request.getParameter("id"));
			producerRepository.deleteById(id);
		}
		request.setAttribute("producers", producerRepository.findAll());
		return page;
	}
	
	
	
	private Producer readProducer(HttpServletRequest request) {
		String idString = request.getParameter("id");
		Long id=null;
		if (idString!=null) {
			id=Long.parseLong(idString);
		}
		Long pib = Long.parseLong(request.getParameter("pib"));
		Long matBroj = Long.parseLong(request.getParameter("maticniBroj"));
		String adresa = request.getParameter("adresa");
		Long mestoId = Long.parseLong(request.getParameter("idMesta"));
		Mesto mesto=mestoRepository.findById(mestoId);
		Producer producer= new Producer(id,pib, matBroj, adresa, mesto);
		return producer;
	}

}
