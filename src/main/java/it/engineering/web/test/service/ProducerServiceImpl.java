package it.engineering.web.test.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

public class ProducerServiceImpl implements ProducerService{
	private static ProducerService instance;
	private ProducerRepository producerRepository;
	private MestoRepository mestoRepository;
	private EntityManagerFactory entityManagerFactory;
	 private ProducerServiceImpl() {
		 producerRepository = ProducerRepositoryImpl.getInstance();
		 mestoRepository=MestoRepositoryImpl.getInstance();
		 entityManagerFactory= MyEntityManagerFactory.getEntityManagerFactory();
	 }
	
	@Override
	public String viewAllProducers(HttpServletRequest request) {
		EntityManager em= entityManagerFactory.createEntityManager();
		List<Producer> producers =producerRepository.findAll(em);
		request.setAttribute("producers", producers);
		return Constants.PAGE_ALL_PRODUCERS;
	}
	@Override
	public void addProducer(HttpServletRequest request) {
		EntityManager em= entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Producer producer = readProducer(request,em);
		producerRepository.saveOrUpdate(producer, em);
		em.getTransaction().commit();
		
	}



	@Override
	public String viewAddProducerPage(HttpServletRequest request) {
		EntityManager em= entityManagerFactory.createEntityManager();
		List<Mesto> mesta = mestoRepository.findAll(em);
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
		EntityManager em= entityManagerFactory.createEntityManager();
		if (button.equalsIgnoreCase("edit")) {
			request.setAttribute("mesta", mestoRepository.findAll(em));
			page = Constants.PAGE_EDIT_PRODUCER;
		}
		Long id = Long.parseLong(request.getParameter("id"));
		Producer producer =producerRepository.findById(id,em);
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
		EntityManager em= entityManagerFactory.createEntityManager();
		if (button.equalsIgnoreCase("back")) {
			page=Constants.PAGE_ALL_PRODUCERS;
			request.setAttribute("producers", producerRepository.findAll(em));
		}
		if (button.equalsIgnoreCase("save changes")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Producer producerOld = producerRepository.findById(id,em);
			Producer newProducer = readProducer(request,em);
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
		EntityManager em= entityManagerFactory.createEntityManager();
		if (button.equalsIgnoreCase("confirm edit")) {
			em.getTransaction().begin();
			Producer producer = readProducer(request,em);
			producerRepository.saveOrUpdate(producer,em);
			em.getTransaction().commit();
		}
		request.setAttribute("producers", producerRepository.findAll(em));
		return page;
	}
	
	@Override
	public String deleteConfirmPressed(HttpServletRequest request) {
		String button =request.getParameter("button");
		String page = Constants.PAGE_ALL_PRODUCERS;
		EntityManager em= entityManagerFactory.createEntityManager();
		if (button.equalsIgnoreCase("confirm delete")) {
			Long id = Long.parseLong(request.getParameter("id"));
			em.getTransaction().begin();
			producerRepository.deleteById(id,em);
			em.getTransaction().commit();
		}
		request.setAttribute("producers", producerRepository.findAll(em));
		return page;
	}
	
	
	
	private Producer readProducer(HttpServletRequest request,EntityManager em) {
		String idString = request.getParameter("id");
		Long id=null;
		if (idString!=null) {
			id=Long.parseLong(idString);
		}
		Long pib = Long.parseLong(request.getParameter("pib"));
		Long matBroj = Long.parseLong(request.getParameter("maticniBroj"));
		String adresa = request.getParameter("adresa");
		Long mestoId = Long.parseLong(request.getParameter("idMesta"));
		Mesto mesto=mestoRepository.findById(mestoId,em);
		Producer producer= new Producer(id,pib, matBroj, adresa, mesto);
		return producer;
	}

}
