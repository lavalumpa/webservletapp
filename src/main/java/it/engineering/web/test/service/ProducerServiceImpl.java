package it.engineering.web.test.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.persistance.MyEntityManagerFactory;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.MestoRepositoryImpl;
import it.engineering.web.test.repository.ProducerRepository;
import it.engineering.web.test.repository.ProducerRepositoryImpl;

@Component
public class ProducerServiceImpl implements ProducerService{
	
	private ProducerRepository producerRepository;
	private MestoRepository mestoRepository;
	private EntityManager em;
	 
	public ProducerServiceImpl() {
		 em= MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		 producerRepository = new ProducerRepositoryImpl(em);
		 mestoRepository= new MestoRepositoryImpl(em);
	 }
	
	@Override
	public String viewAllProducers(HttpServletRequest request) {
		List<Producer> producers =producerRepository.findAll();
		request.setAttribute("producers", producers);
		em.close();
		return Constants.PAGE_ALL_PRODUCERS;
	}
	
	
	@Override
	public String addProducer(HttpServletRequest request) {
		em.getTransaction().begin();
		Producer producer = readProducer(request,em);
		producerRepository.saveOrUpdate(producer);
		em.getTransaction().commit();
		List<Producer> producers =producerRepository.findAll();
		request.setAttribute("producers", producers);
		em.close();
		return Constants.PAGE_ALL_PRODUCERS;
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
		em.close();
		return page;
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
			Producer newProducer = readProducer(request,em);
			request.setAttribute("oldProducer", producerOld);
			request.setAttribute("newProducer", newProducer);
			page=Constants.PAGE_EDIT_PRODUCER_CONFIRM;
		}
		em.close();
		return page;
	}
	

	@Override
	public String editConfirmPressed(HttpServletRequest request) {
		String button =request.getParameter("button");
		String page = Constants.PAGE_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm edit")) {
			em.getTransaction().begin();
			Producer producer = readProducer(request,em);
			producerRepository.saveOrUpdate(producer);
			em.getTransaction().commit();
		}
		request.setAttribute("producers", producerRepository.findAll());
		em.close();
		return page;
	}
	
	@Override
	public String deleteConfirmPressed(HttpServletRequest request) {
		String button =request.getParameter("button");
		String page = Constants.PAGE_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm delete")) {
			Long id = Long.parseLong(request.getParameter("id"));
			em.getTransaction().begin();
			producerRepository.deleteById(id);
			em.getTransaction().commit();
		}
		request.setAttribute("producers", producerRepository.findAll());
		em.close();
		return page;
	}
	
	
	
	private Producer readProducer(HttpServletRequest request,EntityManager em) {
		String idString = request.getParameter("id");
		Long id=null;
		if (idString!=null) {
			id=Long.parseLong(idString);
		}
		String pib =request.getParameter("pib");
		String matBroj =request.getParameter("maticniBroj");
		String adresa = request.getParameter("adresa");
		Long mestoId = Long.parseLong(request.getParameter("idMesta"));
		Mesto mesto=mestoRepository.findById(mestoId);
		Producer producer= new Producer(id,pib, matBroj, adresa, mesto);
		return producer;
	}

}
