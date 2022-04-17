package it.engineering.web.test.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.test.domain.Producer;

public class ProducerRepositoryImpl implements ProducerRepository {
	private static ProducerRepository instance;
	
	private ProducerRepositoryImpl() {
		
	}

	@Override
	public void saveOrUpdate(Producer producer, EntityManager em) {
		em.merge(producer);

	}

	@Override
	public Producer findById(Long id, EntityManager em) {
	
		return em.find(Producer.class, id);
	}
	
	@Override
	public void deleteById(Long id, EntityManager em) {
		Producer production = em.find(Producer.class, id);
		em.remove(production);
		
	}
	
	@Override
	public List<Producer> findAll(EntityManager em){
		String query="SELECT p FROM producer p  ";
		return em.createQuery(query,Producer.class).getResultList();
	}
	
	public static ProducerRepository getInstance() {
		if (instance==null) {
			instance = new ProducerRepositoryImpl();
		}
		return instance;
	}
}
