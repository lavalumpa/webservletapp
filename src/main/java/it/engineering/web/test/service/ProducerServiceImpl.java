package it.engineering.web.test.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.Mesto;
import it.engineering.web.test.domain.Producer;
import it.engineering.web.test.repository.MestoRepository;
import it.engineering.web.test.repository.ProducerRepository;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
	@Autowired
	private MestoRepository mestoRepository;

	@Override
	public String viewAllProducers(HttpServletRequest request) {
		List<Producer> producers = producerRepository.findAll();
		request.setAttribute("producers", producers);
		return Constants.VIEW_ALL_PRODUCERS;
	}

	@Override
	public String addProducer(HttpServletRequest request) {
		Producer producer = readProducer(request);
		producerRepository.saveOrUpdate(producer);

		List<Producer> producers = producerRepository.findAll();
		request.setAttribute("producers", producers);

		return Constants.VIEW_ALL_PRODUCERS;
	}

	@Override
	public String viewAddProducerPage(HttpServletRequest request) {
		List<Mesto> mesta = mestoRepository.findAll();
		request.setAttribute("mesta", mesta);
		return Constants.VIEW_ADD_PRODUCER;
	}

	@Override
	public String producersButtonViewForm(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page = "";
		if (button.equalsIgnoreCase("delete")) {
			page = Constants.VIEW_DELETE_PRODUCER;
		}
		if (button.equalsIgnoreCase("edit")) {
			request.setAttribute("mesta", mestoRepository.findAll());
			page = Constants.VIEW_EDIT_PRODUCER;
		}
		Long id = Long.parseLong(request.getParameter("id"));
		Producer producer = producerRepository.findById(id);
		request.setAttribute("producer", producer);
		return page;
	}

	@Override
	public String editProducer(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page = "";
		System.out.println("button:" + button);
		if (button.equalsIgnoreCase("back")) {
			page = Constants.VIEW_ALL_PRODUCERS;
			request.setAttribute("producers", producerRepository.findAll());
		}
		if (button.equalsIgnoreCase("save changes")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Producer producerOld = producerRepository.findById(id);
			Producer newProducer = readProducer(request);
			request.setAttribute("oldProducer", producerOld);
			request.setAttribute("newProducer", newProducer);
			page = Constants.VIEW_EDIT_PRODUCER_CONFIRM;
		}
		return page;
	}

	@Override
	public String editConfirmPressed(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page = Constants.VIEW_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm edit")) {
			Producer producer = readProducer(request);
			producerRepository.saveOrUpdate(producer);
		}
		request.setAttribute("producers", producerRepository.findAll());

		return page;
	}

	@Override
	public String deleteConfirmPressed(HttpServletRequest request) {
		String button = request.getParameter("button");
		String page = Constants.VIEW_ALL_PRODUCERS;
		if (button.equalsIgnoreCase("confirm delete")) {
			Long id = Long.parseLong(request.getParameter("id"));

			producerRepository.deleteById(id);

		}
		request.setAttribute("producers", producerRepository.findAll());

		return page;
	}

	private Producer readProducer(HttpServletRequest request) {
		String idString = request.getParameter("id");
		Long id = null;
		if (idString != null) {
			id = Long.parseLong(idString);
		}
		String pib = request.getParameter("pib");
		String matBroj = request.getParameter("maticniBroj");
		String adresa = request.getParameter("adresa");
		Long mestoId = Long.parseLong(request.getParameter("idMesta"));
		Mesto mesto = mestoRepository.findById(mestoId);
		Producer producer = new Producer(id, pib, matBroj, adresa, mesto);
		return producer;
	}

}
